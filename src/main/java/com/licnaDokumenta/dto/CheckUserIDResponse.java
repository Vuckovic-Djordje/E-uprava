package com.licnaDokumenta.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CheckUserIDResponse {
    private boolean userHasValidID;
}