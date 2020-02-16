package com.teste.senior.desafiohotel.controller;

import com.teste.senior.desafiohotel.exception.HospedeNaoExistente;
import com.teste.senior.desafiohotel.model.CheckIn;
import com.teste.senior.desafiohotel.service.CheckInService;
import com.teste.senior.desafiohotel.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/checkin")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> criarCheckIn(@Valid @RequestBody CheckIn checkIn) {
        try {
            checkIn = checkInService.criarCheckIn(checkIn);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(checkIn, HttpStatus.OK);
    }

}
