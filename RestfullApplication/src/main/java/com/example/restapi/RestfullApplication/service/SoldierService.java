package com.example.restapi.RestfullApplication.service;

import com.example.restapi.RestfullApplication.controller.request.EditSoldierRequest;
import com.example.restapi.RestfullApplication.controller.response.SoldierResponse;
import com.example.restapi.RestfullApplication.dto.Soldier;
import com.example.restapi.RestfullApplication.entities.SoldierEntity;
import com.example.restapi.RestfullApplication.repository.SoldierRepository;
import com.example.restapi.RestfullApplication.resource.SoldierResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldierService {

    @Autowired
    private SoldierRepository soldierRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SoldierResource soldierResource;


    public SoldierResponse searchSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        SoldierResponse soldierResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        return soldierResponse;
    }

    public void createSoldier(Soldier soldier){
        SoldierEntity soldierEntity = objectMapper.convertValue(soldier, SoldierEntity.class);
        soldierRepository.save(soldierEntity);
    }

    public void editSoldier(Long id, EditSoldierRequest editSoldierRequest) {
        SoldierEntity soldierEntity = objectMapper.convertValue(editSoldierRequest, SoldierEntity.class);
        soldierEntity.setId(id);
        soldierRepository.save(soldierEntity);
    }

    public void deleteSoldier(Long id) {
        SoldierEntity soldier = soldierRepository.findById(id).orElseThrow();
        soldierRepository.delete(soldier);
    }

    public List<Soldier> getAllSoldiers(){
        List<SoldierEntity> all = soldierRepository.findAll();
        List<Soldier> soldierStream = all.stream()
                .map(it -> objectMapper.convertValue(it, Soldier.class))
                .collect(Collectors.toList());
        return soldierStream;
    }
}
