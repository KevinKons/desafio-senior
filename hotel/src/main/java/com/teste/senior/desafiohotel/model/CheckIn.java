package com.teste.senior.desafiohotel.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Entity
@Table(name = "check_ins")
public class CheckIn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private LocalDateTime dataEntrada;

    @Column()
    private LocalDateTime dataSaida;

    @Column(name = "adicional_veiculo", nullable = false)
    private boolean adicionalVeiculo;

    @ManyToOne()
    @JoinColumn(name = "hospede_id")
    private Hospede hospede;

    public int getValor() {
        int total = 0;
        long diasHospedado = dataSaida.getDayOfYear() - dataEntrada.getDayOfYear();
        LocalDateTime data = this.dataEntrada;
        int diaAtual = 1;
        while(diaAtual <= diasHospedado) {
            total += calculaValorDiaria(data);
            diaAtual += 1;
            data = data.plusDays(1);
        }
        if(dataSaida.getHour() >= 16 && dataSaida.getMinute() >= 30)
            if(ehFinalDeSemana(dataSaida))
                total += 150;
            else
                total += 120;

        return total;
    }

    private int calculaValorDiaria(LocalDateTime data) {
        int valor = 0;
        if(ehFinalDeSemana(data)) {
            valor += 150;
            if(adicionalVeiculo)
                valor += 20;
        } else {
            valor += 120;
            if(adicionalVeiculo)
                valor += 15;
        }
        return valor;
    }

    private boolean ehFinalDeSemana(LocalDateTime data) {
        if(data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY)
            return true;
        return false;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }


}
