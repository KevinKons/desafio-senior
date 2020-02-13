package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.CampoNuloException;
import com.teste.senior.desafiohotel.model.Hospede;

public interface HospedeService {

    Hospede cadastrarHospede(Hospede hospede) throws CampoNuloException;
}
