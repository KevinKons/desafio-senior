package com.teste.senior.desafiohotel.exception;

public class HospedeNaoExistente extends Exception {

    public HospedeNaoExistente(String message) {
        super(message);
    }

    public HospedeNaoExistente() {
        super("O hospede buscado não existe");
    }
}
