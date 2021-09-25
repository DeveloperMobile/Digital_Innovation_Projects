package com.example.restapi.RestfullApplication.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditSoldierRequest {

    private String name;
    private String gender;
    private String gunType;
}
