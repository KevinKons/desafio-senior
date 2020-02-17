package com.teste.senior.desafiohotel.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "hospedes")
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, length = 25)
    @Size(min = 3, max = 25)
    @NotNull(message = "Nome não pode ser nulo")
    private String nome;

    @Size(min = 6, max = 6)
    @NotNull(message = "Documento não pode ser nulo")
    @Column(nullable = false, length = 6, unique = true)
    private String documento;

    @Column(nullable = false, length = 14)
    @Size(min = 8, max = 14)
    @NotNull(message = "Telefone não pode ser nulo")
    private String telefone;

    @OneToMany(mappedBy = "hospede")
    @JsonIgnore
    private List<CheckIn> checkIns = new ArrayList<>();

    @Transient
    private int totalGasto;

    @Transient
    private int valorUltimaHospedagem;

    public Hospede(String nome, String documento, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    public Hospede() {

    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<CheckIn> getCheckIns() {
        return checkIns;
    }

    public void setCheckIns(List<CheckIn> checkIns) {
        this.checkIns = checkIns;
    }

    public void calculaTotalGasto() {
        int total = 0;
        for(CheckIn checkIn : checkIns) {
            total += checkIn.getValor();
        }
        this.totalGasto = total;
    }

    public void defineValorUltimaHospedagem() {
        if(checkIns.size() == 0)
            this.valorUltimaHospedagem = 0;
        else {
            Iterator<CheckIn> iterator = checkIns.iterator();
            CheckIn ultimaHospedagem = iterator.next();
            while(iterator.hasNext()) {
                CheckIn checkIn = iterator.next();
                if(ultimaHospedagem.getDataSaida().isBefore(checkIn.getDataSaida())) {
                    ultimaHospedagem = checkIn;
                }
            }
            this.valorUltimaHospedagem = ultimaHospedagem.getValor();
        }
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public int getValorUltimaHospedagem() {
        return valorUltimaHospedagem;
    }

    public void addCheckIn(CheckIn checkIn) {
        this.checkIns.add(checkIn);
    }
}
