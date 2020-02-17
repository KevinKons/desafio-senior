package com.teste.senior.desafiohotel.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class CheckInTest {

    @Test
    public void quando_check_in_dura_dois_dias_e_o_checkout_eh_antes_das_16e30_e_nao_eh_final_de_semana_e_nao_tem_veiculo_deve_retornar_240() {
        String dataEntradaString = "2018-03-14T08:00:00";
        String dataSaidaString = "2018-03-16T12:59:59";
        LocalDateTime dataEntrada = LocalDateTime.parse(dataEntradaString);
        LocalDateTime dataSaida = LocalDateTime.parse(dataSaidaString);
        CheckIn checkIn = new CheckIn();
        checkIn.setDataEntrada(dataEntrada);
        checkIn.setDataSaida(dataSaida);
        checkIn.setAdicionalVeiculo(false);
        assertEquals(240, checkIn.getValor());
    }

    @Test
    public void quando_check_in_dura_dois_dias_e_o_checkout_eh_depois_das_16e30_e_nao_eh_final_de_semana_e_nao_tem_veiculo_deve_retornar_360() {
        String dataEntradaString = "2018-03-14T08:00:00";
        String dataSaidaString = "2018-03-16T23:59:59";
        LocalDateTime dataEntrada = LocalDateTime.parse(dataEntradaString);
        LocalDateTime dataSaida = LocalDateTime.parse(dataSaidaString);
        CheckIn checkIn = new CheckIn();
        checkIn.setDataEntrada(dataEntrada);
        checkIn.setDataSaida(dataSaida);
        checkIn.setAdicionalVeiculo(false);
        assertEquals(360, checkIn.getValor());
    }

    @Test
    public void quando_check_in_dura_um_dia_e_o_checkout_eh_depois_das_16e30_e_eh_final_de_semana_e_nao_tem_veiculo_deve_retornar_300() {
        String dataEntradaString = "2018-03-17T08:00:00";
        String dataSaidaString = "2018-03-18T23:59:59";
        LocalDateTime dataEntrada = LocalDateTime.parse(dataEntradaString);
        LocalDateTime dataSaida = LocalDateTime.parse(dataSaidaString);
        CheckIn checkIn = new CheckIn();
        checkIn.setDataEntrada(dataEntrada);
        checkIn.setDataSaida(dataSaida);
        checkIn.setAdicionalVeiculo(false);
        assertEquals(300, checkIn.getValor());
    }

    @Test
    public void quando_check_in_dura_um_dia_e_o_checkout_eh_depois_das_16e30_e_eh_final_de_semana_e_tem_veiculo_deve_retornar_300() {
        String dataEntradaString = "2018-03-17T08:00:00";
        String dataSaidaString = "2018-03-18T23:59:59";
        LocalDateTime dataEntrada = LocalDateTime.parse(dataEntradaString);
        LocalDateTime dataSaida = LocalDateTime.parse(dataSaidaString);
        CheckIn checkIn = new CheckIn();
        checkIn.setDataEntrada(dataEntrada);
        checkIn.setDataSaida(dataSaida);
        checkIn.setAdicionalVeiculo(true);
        assertEquals(320, checkIn.getValor());
    }

    @Test
    public void quando_chreck_in_dura_dois_dias_e_o_checkout_eh_antes_das_16e30_e_nao_eh_final_de_semana_e_nao_tem_veiculo_deve_retornar_240() {
        String dataEntradaString = "2020-02-16T12:50:50";
        String dataSaidaString = "2020-02-18T10:17:00";
        LocalDateTime dataEntrada = LocalDateTime.parse(dataEntradaString);
        LocalDateTime dataSaida = LocalDateTime.parse(dataSaidaString);
        CheckIn checkIn = new CheckIn();
        checkIn.setDataEntrada(dataEntrada);
        checkIn.setDataSaida(dataSaida);
        checkIn.setAdicionalVeiculo(false);
        assertEquals(270, checkIn.getValor());
    }

}