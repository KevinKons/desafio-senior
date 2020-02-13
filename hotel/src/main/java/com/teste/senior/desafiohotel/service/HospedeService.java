package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.model.Hospede;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospedeService {

    Hospede cadastrarHospede(Hospede hospede);
    Hospede buscarHospedePorNome(String nome);
    Hospede buscarHospedePorDocumento(String documento);
    Hospede buscarHospedePorTelefone(String telefone);
    Hospede editarHospede(long id, Hospede hospede);
    Hospede excluirHospede(long id);
    List<Hospede> buscarTodosOsHospedes();
}
