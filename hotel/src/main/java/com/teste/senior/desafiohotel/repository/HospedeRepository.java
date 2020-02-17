package com.teste.senior.desafiohotel.repository;

import com.teste.senior.desafiohotel.model.Hospede;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface HospedeRepository extends CrudRepository<Hospede, Long> {

    List<Hospede> findAll();
    Hospede findByDocumento(String documento);
    List<Hospede> findByNome(String nome);
    List<Hospede> findByTelefone(String telefone);

    @Query("SELECT DISTINCT h FROM Hospede h " +
            "WHERE h IN (SELECT c.hospede FROM CheckIn c WHERE c.dataEntrada < :data) " +
            "AND h NOT IN (SELECT c.hospede FROM CheckIn c WHERE c.dataEntrada < :data AND c.dataSaida > :data)")
    List<Hospede> naoEstaoNoHotel(@Param("data") LocalDateTime data);

//    @Query(value = "SELECT * FROM Hospede " +
//            "WHERE id IN (SELECT hospede_id FROM CheckIn c WHERE c.dataEntrada < :data) " +
//            "AND id NOT IN (SELECT hospede_id FROM CheckIn c WHERE c.dataEntrada < :data AND c.dataSaida > :data)", nativeQuery = true)
//    List<Hospede> naoEstaoNoHotelNativo(@Param("data") LocalDateTime data);

    /*Ainda Hospedados*/
    List<Hospede> findDistinctHospedesByCheckInsDataSaidaAfterAndCheckInsDataEntradaBefore(LocalDateTime saida, LocalDateTime l);
}
