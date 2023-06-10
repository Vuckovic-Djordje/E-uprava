package com.licnaDokumenta.controller;

import com.licnaDokumenta.dto.CheckUserIDResponse;
import com.licnaDokumenta.dto.IDRequest;
import com.licnaDokumenta.dto.IDResponse;
import com.licnaDokumenta.model.User;
import com.licnaDokumenta.model.UsersId;
import com.licnaDokumenta.service.UsersIdService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Validated
@RequestMapping("/api/id-certificates")
public class IDCertificateController {

    @Autowired
    private UsersIdService usersIdService;

    @PostMapping
    public ResponseEntity<IDResponse> generateIDCertificateForUser(
            @RequestBody @Valid IDRequest request
    ){
        return ResponseEntity.ok(usersIdService.generateID(request));
    }

    @GetMapping("/{jmbg}")
    public ResponseEntity<CheckUserIDResponse> checkIfUserHasCertificate(@PathVariable String jmbg) {
        return ResponseEntity.ok(usersIdService.checkUserIDResponse(jmbg));
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteID(@PathVariable Long id) {
        usersIdService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createIDforUser")
    public ResponseEntity<UsersId> save(UsersId usersId) {
        usersIdService.save(usersId);
        return new ResponseEntity<>(usersId, HttpStatus.CREATED);
    }
}