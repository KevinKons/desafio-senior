package com.teste.senior.desafiohotel.model;

import org.junit.Test;


import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.Assert.*;

public class HospedeTest {

    @Test
    public void testaSetUltimaHospedagem() {
        LocalDateTime dataEntrada1 = LocalDateTime.parse("2018-03-14T08:00:00");
        LocalDateTime dataSaida1 = LocalDateTime.parse("2018-03-16T08:00:00");
        CheckIn ultimoCheckIn = new CheckIn();
        ultimoCheckIn.setDataEntrada(dataEntrada1);
        ultimoCheckIn.setDataSaida(dataSaida1);

        LocalDateTime dataEntrada2 = LocalDateTime.parse("2018-01-14T08:00:00");
        LocalDateTime dataSaida2 = LocalDateTime.parse("2018-01-16T08:00:00");
        CheckIn checkin1 = new CheckIn();
        checkin1.setDataEntrada(dataEntrada2);
        checkin1.setDataSaida(dataSaida2);

        LocalDateTime dataEntrada3 = LocalDateTime.parse("2018-03-01T08:00:00");
        LocalDateTime dataSaida3 = LocalDateTime.parse("2018-03-03T08:00:00");
        CheckIn checkin2 = new CheckIn();
        checkin2.setDataEntrada(dataEntrada3);
        checkin2.setDataSaida(dataSaida3);

        Hospede hospede = new Hospede();
        hospede.getTotalGasto();
        hospede.setCheckIns(Arrays.asList(checkin1, ultimoCheckIn, checkin2));

        hospede.defineValorUltimaHospedagem();
        assertEquals(240, hospede.getValorUltimaHospedagem());
    }

}