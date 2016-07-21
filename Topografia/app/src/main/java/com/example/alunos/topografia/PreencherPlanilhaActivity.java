package com.example.alunos.topografia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alunos.topografia.com.example.alunos.topografia.dominio.BancoDados;
import com.example.alunos.topografia.com.example.alunos.topografia.dominio.Planilha;

public class PreencherPlanilhaActivity extends AppCompatActivity {

    EditText inputNomeEstacao;
    EditText inputPontoVisado;

    EditText inputGrauHorizontal;
    EditText inputMinHorizontal;
    EditText inputSegHorizontal;

    EditText inputFioSuperior;
    EditText inputFioMedio;
    EditText inputFioInferior;

    EditText inputGrauVertical;
    EditText inputMinVertical;
    EditText inputSegVertical;

    EditText inputAlturaAparelho;
    boolean eNovaEstacao = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preencherplanilha);

        inputNomeEstacao = (EditText) findViewById(R.id.txtEstacao);
        inputPontoVisado = (EditText) findViewById(R.id.txtVisado);

        inputGrauHorizontal = (EditText) findViewById(R.id.txtGrauHorizontal);
        inputMinHorizontal = (EditText) findViewById(R.id.txtMinutoHorizontal);
        inputSegHorizontal = (EditText) findViewById(R.id.txtSegundoHorizontal);

        inputFioSuperior = (EditText) findViewById(R.id.txtSuperior);
        inputFioMedio = (EditText) findViewById(R.id.txtMedio);
        inputFioInferior = (EditText) findViewById(R.id.txtInferior);

        inputGrauVertical = (EditText) findViewById(R.id.txtGrauVertical);
        inputMinVertical = (EditText) findViewById(R.id.txtMinutoVertical);
        inputSegVertical = (EditText) findViewById(R.id.txtSegundoVertical);

        inputAlturaAparelho = (EditText) findViewById(R.id.txtAltura);

    }

    public void salvarCampos(){

        Planilha p  = new Planilha();

        p.setNomeEstacao(String.valueOf(inputNomeEstacao));

        String nomeEstacao = inputNomeEstacao.getText().toString();
        if (eNovaEstacao){
            BancoDados.listaEstacoes.add(nomeEstacao);
            eNovaEstacao = false;
        }
        String pontoVisado = inputPontoVisado.getText().toString();

        int grauHorizontal = Integer.parseInt( inputGrauHorizontal.getText().toString());
        int minutoHorizontal = Integer.parseInt(inputMinHorizontal.getText().toString());
        int segundoHorizontal = Integer.parseInt(inputSegHorizontal.getText().toString());

        int superior = Integer.parseInt(inputFioSuperior.getText().toString());
        int medio = Integer.parseInt(inputFioMedio.getText().toString());
        int inferior = Integer.parseInt(inputFioInferior.getText().toString());

        int grauVertical = Integer.parseInt( inputGrauVertical.getText().toString());
        int minutoVertical = Integer.parseInt(inputMinVertical.getText().toString());
        int segundoVertical = Integer.parseInt(inputSegVertical.getText().toString());

        double alturaAparelho = Double.parseDouble(inputAlturaAparelho.getText().toString());

        p.setNomeEstacao(nomeEstacao);
        p.setPontoVisado(pontoVisado);

        p.setGrauHorizontal(grauHorizontal);
        p.setMinutoHorizontal(minutoHorizontal);
        p.setSegundoHorizontal(segundoHorizontal);

        p.setFioSuperior(superior);
        p.setFioMedio(medio);
        p.setFioInferior(inferior);

        p.setGrauVertical(grauVertical);
        p.setMinutoVertical(minutoVertical);
        p.setSegundoVertical(segundoVertical);

        p.setAlturaAparelho(alturaAparelho);

        BancoDados.basededados.add(p);
        Toast.makeText(this, "Dados Salvos", Toast.LENGTH_SHORT).show();

    }
    public void zerarCampos(){

        inputPontoVisado.setText("");

        inputGrauHorizontal.setText("");
        inputMinHorizontal.setText("");
        inputSegHorizontal.setText("");

        inputFioSuperior.setText("");
        inputFioMedio.setText("");
        inputFioInferior.setText("");

        inputGrauVertical.setText("");
        inputMinVertical.setText("");
        inputSegVertical.setText("");
    }
    public void novoPonto(View v) {

        salvarCampos();
        zerarCampos();

    }
    public void novaEstacao(View v) {
        salvarCampos();
        zerarCampos();
        inputNomeEstacao.setText("");
        inputAlturaAparelho.setText("");
        eNovaEstacao = true;
    }

}
