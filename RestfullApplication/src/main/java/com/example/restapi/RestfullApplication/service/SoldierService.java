package com.example.restapi.RestfullApplication.service;

import com.example.restapi.RestfullApplication.controller.request.EditSoldierRequest;
import com.example.restapi.RestfullApplication.dto.Soldier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SoldierService {

    public Soldier searchSoldier(String cpf) {
        Soldier soldier = new Soldier();
        soldier.setCpf(cpf);
        soldier.setName("Lauren");
        soldier.setGender("female");
        soldier.setGunType("M4-A4");
        return soldier;
    }

    public void createSoldier(Soldier soldier) {

    }

    public void alterSoldier(String cpf, EditSoldierRequest editSoldierRequest) {
    }

    public void deleteSoldier(String cpf) {
    }

    public List<Soldier> findAllSoldiers() {
        Soldier soldier1 = new Soldier();
        soldier1.setCpf("123456789");
        soldier1.setName("Lauren");
        soldier1.setGender("female");
        soldier1.setGunType("M4-A4");

        Soldier soldier2 = new Soldier();
        soldier2.setCpf("987654321");
        soldier2.setName("Lance");
        soldier2.setGender("male");
        soldier2.setGunType("AK-47");

        return Arrays.asList(soldier1, soldier2);
    }
}
