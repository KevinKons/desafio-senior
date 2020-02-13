package com.teste.senior.desafiohotel.repository;

import com.teste.senior.desafiohotel.model.Hospede;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospedeRepository extends CrudRepository<Hospede, Long> {

    Hospede findByDocumento(String documento);
    List<Hospede> findAll();
    Hospede findByNome(String nome);
    Hospede findByTelefone(String telefone);
}
