package com.example.restapi.RestfullApplication.resource;

import com.example.restapi.RestfullApplication.controller.SoldierController;
import com.example.restapi.RestfullApplication.controller.response.SoldierListResponse;
import com.example.restapi.RestfullApplication.controller.response.SoldierResponse;
import com.example.restapi.RestfullApplication.entities.SoldierEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SoldierResource {
    private ObjectMapper objectMapper;

    public SoldierResource(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldierListResponse createLink(SoldierEntity soldierEntity) {
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
        Link link = linkTo(methodOn(SoldierController.class).searchSoldier(soldierEntity.getCpf()).withSelfRel());
        soldierListResponse.add(link);
        return soldierListResponse;
    }
}
