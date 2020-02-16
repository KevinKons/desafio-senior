package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.HospedeNaoExistente;
import com.teste.senior.desafiohotel.model.CheckIn;
import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    CheckInRepository checkInRepository;

    @Autowired
    HospedeService hospedeService;

    @Override
    public CheckIn criarCheckIn(CheckIn checkIn) throws HospedeNaoExistente {
        Hospede hospede = checkIn.getHospede();
        if(hospede.getDocumento() != null)
            hospede = hospedeService.buscarHospedePorDocumento(hospede.getDocumento());
        else if(hospede.getNome() != null)
            hospede = hospedeService.buscarHospedePorNome(hospede.getNome()).get(0);
        else if(hospede.getTelefone() != null)
            hospede = hospedeService.buscarHospedePorTelefone(hospede.getTelefone()).get(0);
        else
            throw new HospedeNaoExistente();

        checkIn.setHospede(hospede);
        checkIn = checkInRepository.save(checkIn);
        return checkIn;
    }
}
