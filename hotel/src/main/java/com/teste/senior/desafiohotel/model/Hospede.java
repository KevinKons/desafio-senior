package com.teste.senior.desafiohotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "hospedes")
public class Hospede implements Serializable {

    @Id
    private long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 6)
    private String documento;

    public Hospede(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
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
}
