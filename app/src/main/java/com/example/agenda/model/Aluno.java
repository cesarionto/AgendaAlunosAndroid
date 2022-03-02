package com.example.agenda.model;

import androidx.annotation.NonNull;

public class Aluno {
    private final String nomeCompleto;
    private final String telefone;
    private final String email;

    public Aluno(String nomeCompleto, String telefone, String email) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
        return this.nomeCompleto;
    }
}
