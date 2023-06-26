package br.paulocalderan.tinnova.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseError {

    private String mensagem;

    public ResponseError(String errorMessage) {
        this.mensagem = errorMessage;
    }

    public String getMensagem() {
        return mensagem;
    }
}
