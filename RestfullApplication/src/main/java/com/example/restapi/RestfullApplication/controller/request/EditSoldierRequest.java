package com.example.restapi.RestfullApplication.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditSoldierRequest {

    private String cpf;
    private String name;
    private String gender;
    private String gunType;
    private String status;
}
