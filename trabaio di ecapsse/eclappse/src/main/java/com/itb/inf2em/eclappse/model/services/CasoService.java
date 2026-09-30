package com.itb.inf2em.eclappse.model.services;



import com.itb.inf2em.eclappse.model.entity.Caso;
import com.itb.inf2em.eclappse.model.repository.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CasoService {



    private CasoRepository casoRepository;

    public List<Caso> findAll() {
        return casoRepository.findAll();
    }

    @Transactional
    public Caso save(Caso caso) {
            caso.setId(null);
            return casoRepository.save(caso);
    }

}