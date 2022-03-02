package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;

    private final AlunoDAO alunoDAO = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(R.string.label_add_alunos);
        inicializaCampos();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button buttonSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criarAluno();
                salvarAluno(alunoCriado);
            }
        });
    }

    private void inicializaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome_aluno);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salvarAluno(Aluno alunoCriado) {
        alunoDAO.salvar(alunoCriado);
        abreListaAlunoActivity();
        finish();
    }

    private void abreListaAlunoActivity() {
        startActivity(new Intent(FormularioAlunoActivity.this, ListaAlunosActivity.class));
    }

    @NonNull
    private Aluno criarAluno() {
        String nomeCompleto = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();
        Aluno alunoCriado = new Aluno(nomeCompleto, telefone, email);
        return alunoCriado;
    }
}