package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.HospedeNaoExistente;
import com.teste.senior.desafiohotel.model.CheckIn;
import org.springframework.stereotype.Service;

@Service
public interface CheckInService {
    CheckIn criarCheckIn(CheckIn checkIn) throws HospedeNaoExistente;
}
