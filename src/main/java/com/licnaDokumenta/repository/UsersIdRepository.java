package com.licnaDokumenta.repository;

import com.licnaDokumenta.model.UsersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersIdRepository extends JpaRepository<UsersId, Long> {

    @Query(value = "select * from certificate where user_jmbg = ?1",
            nativeQuery = true)
    List<UsersId> findByUserJmbg(String jmbg);

}