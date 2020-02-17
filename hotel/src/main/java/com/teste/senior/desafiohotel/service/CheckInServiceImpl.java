package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.HospedeNaoExistente;
import com.teste.senior.desafiohotel.model.CheckIn;
import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.repository.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    CheckInRepository checkInRepository;

    @Autowired
    HospedeService hospedeService;

    @Override
    public CheckIn criarCheckIn(CheckIn checkIn) throws Exception {
        if(ehDepois(checkIn.getDataEntrada(), checkIn.getDataSaida()))
            throw new Exception("Data de entrada deve ser antes da data de saída");
        Hospede hospede = buscaHospedeCadastrado(checkIn.getHospede());
        checkIn.setHospede(hospede);
        hospede.addCheckIn(checkIn);
        checkIn = checkInRepository.save(checkIn);
        hospede.calculaTotalGasto();
        hospede.defineValorUltimaHospedagem();
        return checkIn;
    }

    private boolean ehDepois(LocalDateTime dataEntrada, LocalDateTime dataSaida) {
        if(dataEntrada.isAfter(dataSaida))
            return true;
        return false;
    }

    private Hospede buscaHospedeCadastrado(Hospede hospede) throws HospedeNaoExistente {
        if(hospede.getDocumento() != null)
            return hospedeService.buscarHospedePorDocumento(hospede.getDocumento());
        else if(hospede.getNome() != null)
            return hospedeService.buscarHospedePorNome(hospede.getNome()).get(0);
        else if(hospede.getTelefone() != null)
            return hospedeService.buscarHospedePorTelefone(hospede.getTelefone()).get(0);
        else
            throw new HospedeNaoExistente();
    }
}
