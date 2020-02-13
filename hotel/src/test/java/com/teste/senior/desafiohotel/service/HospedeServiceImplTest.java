package com.teste.senior.desafiohotel.service;

import com.teste.senior.desafiohotel.DesafioHotelApplicationTests;
import com.teste.senior.desafiohotel.exception.CampoNuloException;
import com.teste.senior.desafiohotel.model.Hospede;
import com.teste.senior.desafiohotel.repository.HospedeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;

import static org.mockito.Mockito.*;

public class HospedeServiceImplTest extends DesafioHotelApplicationTests {

    @Autowired
    HospedeService hospedeService;

    String nome = "Kevin";
    String documento = "123456";
    Hospede hospede;

    @MockBean
    HospedeRepository hospedeRepository;

    @Test(expected = CampoNuloException.class)
    public void quando_nomeOuDocumentoEhNulo_deve_lancarExcecao() throws CampoNuloException {
        hospedeService.cadastrarHospede(new Hospede());
    }

    @Test
    public void quando_camposEstaoOk_deve_cadastrar() throws CampoNuloException {
        hospede = new Hospede(nome, documento);
        when(hospedeRepository.save(hospede)).thenReturn(hospede);

        Hospede result = hospedeService.cadastrarHospede(hospede);

        Assert.assertEquals(result, hospede);
        verify(hospedeRepository, times(1)).save(hospede);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void quando_documentoJaEstaCadastrado_deve_lancarExcecao() throws CampoNuloException, PSQLException {
        hospede = new Hospede(nome, documento);
        when(hospedeRepository.save(any())).thenThrow(DataIntegrityViolationException.class);

        hospedeService.cadastrarHospede(hospede);

        verify(hospedeRepository, times(1)).save(hospede);
        verifyNoMoreInteractions(hospedeRepository);
    }

}