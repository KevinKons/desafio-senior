package com.teste.senior.desafiohotel.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "hospedes")
public class Hospede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false, length = 25)
    @Size(min = 3, max = 25)
    private String nome;

    @Column(nullable = false, length = 6, unique = true)
    @Size(min = 6, max = 6)
    private String documento;

    public Hospede(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return Objects.equals(nome, hospede.nome) &&
                Objects.equals(documento, hospede.documento);
    }
}
