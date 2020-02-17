package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.exception.HospedeNaoExistente;
import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class HospedeServiceImpl implements HospedeService {

    @Autowired
    HospedeRepository hospedeRepository;

    @Override
    public Hospede cadastrarHospede(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    @Override
    public List<Hospede> buscarHospedePorNome(String nome) throws HospedeNaoExistente {
        List<Hospede> hospedes = hospedeRepository.findByNome(nome);
        if(hospedes.size() == 0)
            throw new HospedeNaoExistente();
        defineValoresHospedagem(hospedes);
        return hospedes;
    }

    @Override
    public Hospede buscarHospedePorDocumento(String documento) throws HospedeNaoExistente {
        Hospede hospede = hospedeRepository.findByDocumento(documento);
        if(hospede == null) {
            throw new HospedeNaoExistente();}
        hospede.calculaTotalGasto();
        hospede.defineValorUltimaHospedagem();
        return hospede;
    }

    @Override
    public List<Hospede> buscarHospedePorTelefone(String telefone) throws HospedeNaoExistente {
        List<Hospede> hospedes = hospedeRepository.findByTelefone(telefone);
        if(hospedes.size() == 0)
            throw new HospedeNaoExistente();
        defineValoresHospedagem(hospedes);
        return hospedes;
    }

    @Override
    public Hospede editarHospede(long id, Hospede hospedeNovaInformacao) throws HospedeNaoExistente {
        Hospede hospede;
        try {
            hospede = hospedeRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new HospedeNaoExistente();
        }
        hospede.setNome(hospedeNovaInformacao.getNome());
        hospede.setDocumento(hospedeNovaInformacao.getDocumento());
        hospede.setTelefone(hospedeNovaInformacao.getTelefone());
        return hospedeRepository.save(hospede);
    }

    @Override
    public Hospede excluirHospede(long id) throws HospedeNaoExistente {
        Hospede hospede;
        try {
            hospede = hospedeRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw new HospedeNaoExistente();
        }
        hospedeRepository.delete(hospede);
        return hospede;
    }

    @Override
    public List<Hospede> buscarTodosOsHospedes() {
        List<Hospede> hospedes = hospedeRepository.findAll();
        defineValoresHospedagem(hospedes);
        return hospedes;
    }

    @Override
    public List<Hospede> buscarHospedesNoHotel() {
        LocalDateTime agora = LocalDateTime.now();
        List<Hospede> hospedes = hospedeRepository.
                findDistinctHospedesByCheckInsDataSaidaAfterAndCheckInsDataEntradaBefore(agora, agora);
        defineValoresHospedagem(hospedes);
        return hospedes;
    }

    private void defineValoresHospedagem(List<Hospede> hospedes) {
        for(Hospede hospede : hospedes) {
            hospede.calculaTotalGasto();
            hospede.defineValorUltimaHospedagem();
        }
    }
}
