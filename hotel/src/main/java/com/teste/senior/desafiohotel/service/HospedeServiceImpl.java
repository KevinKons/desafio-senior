package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HospedeServiceImpl implements HospedeService {

    @Autowired
    HospedeRepository hospedeRepository;

    @Override
    public Hospede cadastrarHospede(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @Override
    public Hospede buscarHospedePorNome(String nome) {
        return hospedeRepository.findByNome(nome);
    }

    @Override
    public Hospede buscarHospedePorDocumento(String documento) {
        return hospedeRepository.findByDocumento(documento);
    }

    @Override
    public Hospede buscarHospedePorTelefone(String telefone) {
        return hospedeRepository.findByTelefone(telefone);
    }

    @Override
    public Hospede editarHospede(long id, Hospede hospedeNovaInformacao) {
        Hospede hospedeAtual = hospedeRepository.findById(id).get();
        hospedeAtual.setNome(hospedeNovaInformacao.getNome());
        hospedeAtual.setDocumento(hospedeNovaInformacao.getDocumento());
        return hospedeRepository.save(hospedeNovaInformacao);
    }

    @Override
    public Hospede excluirHospede(long id) {
        Hospede hospede = hospedeRepository.findById(id).get();
        hospedeRepository.delete(hospede);
        return hospede;
    }

    @Override
    public List<Hospede> buscarTodosOsHospedes() {
        return hospedeRepository.findAll();
    }
}
