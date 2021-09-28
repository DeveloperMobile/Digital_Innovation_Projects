package com.example.restapi.RestfullApplication.controller.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;


@Getter
@Setter
public class SoldierListResponse extends RepresentationModel {

    private Long id;
    private String name;
    private String race;

}
