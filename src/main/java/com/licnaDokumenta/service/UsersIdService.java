package com.licnaDokumenta.service;


import com.licnaDokumenta.dto.CheckUserIDResponse;
import com.licnaDokumenta.dto.IDRequest;
import com.licnaDokumenta.dto.IDResponse;
import com.licnaDokumenta.model.UsersId;
import com.licnaDokumenta.repository.UserRepository;
import com.licnaDokumenta.repository.UsersIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersIdService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersIdRepository usersIdRepository;

    public IDResponse generateID(final IDRequest request) {

        IDResponse response =  new IDResponse("Izdaje se uverenje o vazecoj licnoj karti za  "
                + request.getName() + " " + request.getLastName()
                + ", JMBG: " + request.getJmbg() + " u svrhu " + request.getPurpose());

        noteUserRequestedCertificate(request, response.getMessage());

        return response;
    }

    private void noteUserRequestedCertificate(final IDRequest request, final String message) {
        UsersId usersId = new UsersId(request.getJmbg(), message);
        usersIdRepository.save(usersId);
    }

    public CheckUserIDResponse checkUserIDResponse(final String jmbg) {
        List<UsersId> idsOfUser = usersIdRepository.findByUserJmbg(jmbg);
        if(idsOfUser.isEmpty()) {
            return new CheckUserIDResponse(false);
        }
        return new CheckUserIDResponse(true);
    }
}