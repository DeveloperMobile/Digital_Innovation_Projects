package com.vittorinoboost.springmvc.repository;

import com.vittorinoboost.springmvc.model.Jedi;
import org.springframework.data.repository.CrudRepository;

public interface JediRepository extends CrudRepository<Jedi, Long> {
}
