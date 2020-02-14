package com.teste.senior.desafiohotel.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return Objects.equals(nome, hospede.nome) &&
                Objects.equals(documento, hospede.documento);
    }
}
