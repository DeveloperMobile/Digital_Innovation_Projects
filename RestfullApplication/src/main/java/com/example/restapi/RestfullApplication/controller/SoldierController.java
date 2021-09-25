package com.example.restapi.RestfullApplication.controller;

import com.example.restapi.RestfullApplication.controller.request.EditSoldierRequest;
import com.example.restapi.RestfullApplication.dto.Soldier;
import com.example.restapi.RestfullApplication.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

    @Autowired
    private SoldierService soldierService;


    @GetMapping("/{cpf}")
    public ResponseEntity<Soldier> searchSoldier(@PathVariable String cpf) {

        Soldier soldier = soldierService.searchSoldier(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(soldier);
        /*return new ResponseEntity<>("message",HttpStatus.OK);*/
    }

    @PostMapping
    public ResponseEntity createSoldier(@RequestBody Soldier soldier) {
        soldierService.createSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{cpf}")
    public ResponseEntity editSoldier(@PathVariable String cpf,
                                      @RequestBody EditSoldierRequest editSoldierRequest) {
        soldierService.alterSoldier(cpf, editSoldierRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{cpf}")
    public ResponseEntity deleteSoldier(@PathVariable String cpf) {
        soldierService.deleteSoldier(cpf);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Soldier>> getAllSoldiers() {
        List<Soldier> soldiers = soldierService.findAllSoldiers();
        return ResponseEntity.status(HttpStatus.OK).body(soldiers);
    }
}
