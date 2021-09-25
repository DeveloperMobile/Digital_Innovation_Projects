package com.vittorinoboost.springmvc.service;

import com.vittorinoboost.springmvc.exception.JediNotFoundException;
import com.vittorinoboost.springmvc.model.Jedi;
import com.vittorinoboost.springmvc.repository.JediRepo;
import com.vittorinoboost.springmvc.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

//Business Rules

public class JediService {
    @Autowired
    private JediRepo jediRepo;

    @Autowired
    private JediRepository jediRepository;

    //---------------------Get all method-----------------------------------

    public List<Jedi> findAll() {
        return jediRepo.findAll();
    }

    //---------------------Get by Id method-----------------------------------

    public Jedi findById(Long id) {
        final Optional<Jedi> jedi = jediRepo.findById(id);

        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }
    //---------------------Post method-----------------------------------

    public Jedi save(Jedi jedi) {
        return jediRepo.save(jedi);
    }

    //---------------------Put method------------------------------------

    public Jedi update(final Long id, final Jedi dto) {

        final Optional<Jedi> jediEntity = jediRepo.findById(id);
        final Jedi jedi;

        if (jediEntity.isPresent()) {
            jedi = jediEntity.get();
        } else {
           throw new JediNotFoundException();
        }

        jedi.setName(dto.getName());
        jedi.setLastName(dto.getLastName());

        return jediRepo.save(jedi);
    }
    //--------------------Delete Method-----------------------------------

    public void deleteById(Long id) {
        final Jedi jedi = findById(id);

        jediRepo.delete(jedi);
    }
}
