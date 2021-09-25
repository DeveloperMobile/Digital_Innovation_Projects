package br.com.globallabs.springwebmvc.service;

import br.com.globallabs.springwebmvc.exception.JediNotFoundException;
import br.com.globallabs.springwebmvc.model.Jedi;
import br.com.globallabs.springwebmvc.repositories.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JediService {

    @Autowired
    private JediRepository jediRepo;

    //--------------------------------------------------------

    public List<Jedi> findAll() {
        return jediRepo.findAll();
    }

    //---------------------------------------------------------

    public Jedi findById(final Long id) {
        final Optional<Jedi> jedi = jediRepo.findById(id);

        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    //--------------------------------------------------------

    public Jedi save(Jedi jedi) {
        return jediRepo.save(jedi);
    }

    //--------------------------------------------------------

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

    //-----------------------------------------------
    public void delete(final Long id) {
        final Jedi jedi = findById(id);

        jediRepo.delete(jedi);
    }


}
