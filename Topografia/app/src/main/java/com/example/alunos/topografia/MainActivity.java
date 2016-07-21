package com.example.alunos.topografia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText inputNomeResponsavel;
    EditText inputNumeroEstacoes;
    EditText inputNomeProjeto;
    EditText inputPrecisaoAparelho;

    RadioButton inputSentidoCaminhamento; //nao sei

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void abrirEstacoes(View v) {

        Intent it = new Intent(this, EstacoesActivity.class);
        startActivity(it);
    }

    public void abrirTelaCarregamento(View v) {

        Intent it = new Intent(this, CarregamentoActivity.class);
        startActivity(it);
    }
}