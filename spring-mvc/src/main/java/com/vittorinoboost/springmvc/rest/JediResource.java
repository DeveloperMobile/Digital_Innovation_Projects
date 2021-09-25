package com.vittorinoboost.springmvc.rest;

import com.vittorinoboost.springmvc.model.Jedi;
import com.vittorinoboost.springmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class JediResource {

    //Dependency Injection of Service Class
    @Autowired
    private JediService jediService;

    //-------------------------------------------------------------------
    // Get All method
    @GetMapping("/api/jedi")
    public List<Jedi> findAllJedi() {

        return jediService.findAll();
    }
    //-------------------------------------------------------------------
    //Get by Id method
    @GetMapping("api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {

        final Jedi jedi = jediService.findById(id);

        return ResponseEntity.ok(jedi);
    }
    //-------------------------------------------------------------------
    //Post method
    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi) {

        return jediService.save(jedi);
    }
    //-------------------------------------------------------------------
    //Edit method by Id (Change all)
    @PutMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi dto ) {

        final Jedi jedi = jediService.update(id, dto);

        return ResponseEntity.ok(jedi);
    }
    //-----------------------------------------------------------------
    //Delete by Id
    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id) {

        jediService.deleteById(id);
    }
}
