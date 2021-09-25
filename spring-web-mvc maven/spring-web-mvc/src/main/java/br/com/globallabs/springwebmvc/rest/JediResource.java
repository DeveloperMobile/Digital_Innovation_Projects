package br.com.globallabs.springwebmvc.rest;

import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JediResource {

    @Autowired
    private JediService jediService;

    //--------------------------------------
    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi() {
        return jediService.findAll();
    }

    //--------------------------------------
    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Jedi jedi = jediService.findById(id);
        return ResponseEntity.ok(jedi);
    }

    //--------------------------------------
    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createjedi(@Valid @RequestBody Jedi jedi) {
        return jediService.save(jedi);
    }

    //--------------------------------------
    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> upadateJedi(@PathVariable("id") long id, @Valid @RequestBody Jedi dto) {
        final Jedi jedi = jediService.update(id, dto);
        return ResponseEntity.ok(jedi);
    }

    //--------------------------------------
    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        jediService.delete(id);
    }
}
