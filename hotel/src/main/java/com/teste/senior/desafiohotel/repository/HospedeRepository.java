package com.teste.senior.desafiohotel.repository;

import com.teste.senior.desafiohotel.model.Hospede;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HospedeRepository extends CrudRepository<Hospede, Long> {

    List<Hospede> findAll();
    Hospede findByDocumento(String documento);
    List<Hospede> findByNome(String nome);
    List<Hospede> findByTelefone(String telefone);
}
