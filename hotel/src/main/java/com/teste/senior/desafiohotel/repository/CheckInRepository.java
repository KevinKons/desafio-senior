package com.teste.senior.desafiohotel.repository;

import com.teste.senior.desafiohotel.model.CheckIn;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CheckInRepository extends CrudRepository<CheckIn, Long> {

//    List<CheckIn> findCheckInsByDateSaidaBeforeDistinctByHospede(LocalDateTime saida);
//    List<CheckIn> findCheckInsByDistinctByHospedeDateSaidaBefore(LocalDateTime saida);

//    CheckIn find
}
