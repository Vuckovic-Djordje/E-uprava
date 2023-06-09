package com.licnaDokumenta.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
public class UsersId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userJmbg;
    private String name;
    private String lastname;
    private String address;
    private String dateOfBirth;
    private String message;



    public UsersId(String userJmbg, String message) {
        this.userJmbg = userJmbg;
        this.message = message;
    }
}
