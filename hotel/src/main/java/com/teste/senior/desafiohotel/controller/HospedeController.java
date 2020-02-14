package com.teste.senior.desafiohotel.controller;

import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.service.HospedeService;
import com.teste.senior.desafiohotel.util.CustomErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/hospede")
public class HospedeController {

    private static final String DOCUMENTO_JA_CADASTRADO = "Já existe um hospede cadastrado com o documento informado";

    @Autowired
    HospedeService hospedeService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> criarHospede(@Valid @RequestBody Hospede hospede) {
        try {
            hospede = hospedeService.cadastrarHospede(hospede);
            return new ResponseEntity<>(hospede, HttpStatus.OK);
        } catch (DataIntegrityViolationException ex) {
            return new ResponseEntity<>(new CustomErrorType(DOCUMENTO_JA_CADASTRADO), HttpStatus.CONFLICT);
        }
    }

    @GetMapping(path = "/nome/{nome}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarHospedePorNome(@PathVariable String nome) {
        try {
            List<Hospede> hospedes = hospedeService.buscarHospedePorNome(nome);
            if (hospedes.size() > 1)
                return new ResponseEntity<>(hospedes, HttpStatus.OK);
            return new ResponseEntity<>(hospedes.get(0), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/documento/{documento}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarHospedePorDocumento(@PathVariable String documento) {
        try {
            Hospede hospedes = hospedeService.buscarHospedePorDocumento(documento);
            return new ResponseEntity<>(hospedes, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/telefone/{telefone}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarHospedePorTelefone(@PathVariable String telefone) {
        try {
            List<Hospede> hospedes = hospedeService.buscarHospedePorTelefone(telefone);
            if (hospedes.size() > 1)
                return new ResponseEntity<>(hospedes, HttpStatus.OK);
            return new ResponseEntity<>(hospedes.get(0), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> editarHospede(@PathVariable long id, @Valid @RequestBody Hospede hospede) {
        try {
            hospede = hospedeService.editarHospede(id, hospede);
            return new ResponseEntity<>(hospede, HttpStatus.OK);
        } catch (DataIntegrityViolationException ex) {
            return new ResponseEntity<>(new CustomErrorType(DOCUMENTO_JA_CADASTRADO), HttpStatus.CONFLICT);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> excluirHospede(@PathVariable long id) {
        try {
            Hospede hospede = hospedeService.excluirHospede(id);
            return new ResponseEntity<>(hospede, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> buscarTodosHospe() {
        try {
            List<Hospede> hospedes = hospedeService.buscarTodosOsHospedes();
            return new ResponseEntity<>(hospedes, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new CustomErrorType(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}