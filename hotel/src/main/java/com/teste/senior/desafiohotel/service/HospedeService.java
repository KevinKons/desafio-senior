package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.HospedeNaoExistente;
import com.teste.senior.desafiohotel.model.Hospede;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HospedeService {

    Hospede cadastrarHospede(Hospede hospede);
    List<Hospede> buscarHospedePorNome(String nome) throws HospedeNaoExistente;
    Hospede buscarHospedePorDocumento(String documento) throws HospedeNaoExistente;
    List<Hospede> buscarHospedePorTelefone(String telefone) throws HospedeNaoExistente;
    Hospede editarHospede(long id, Hospede hospede) throws HospedeNaoExistente;
    Hospede excluirHospede(long id) throws HospedeNaoExistente;
    List<Hospede> buscarTodosOsHospedes();
}
