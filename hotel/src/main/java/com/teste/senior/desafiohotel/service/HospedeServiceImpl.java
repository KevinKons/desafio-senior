package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.CampoNuloException;
import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;


@Component
public class HospedeServiceImpl implements HospedeService {

    @Autowired
    HospedeRepository hospedeRepository;

    @Override
    public Hospede cadastrarHospede(Hospede hospede) throws CampoNuloException {
        if(hospede.getNome() == null)
            throw new CampoNuloException("Campo nome não pode ser nulo");
        if(hospede.getDocumento() == null)
            throw new CampoNuloException("Campo nome não pode ser nulo");

        Hospede cadastrado = hospedeRepository.save(hospede);

        return cadastrado;
    }
}
