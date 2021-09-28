package com.example.restapi.RestfullApplication.repository;

import com.example.restapi.RestfullApplication.dto.Soldier;
import com.example.restapi.RestfullApplication.entities.SoldierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {
}
