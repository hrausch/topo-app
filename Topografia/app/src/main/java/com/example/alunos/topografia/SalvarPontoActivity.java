package com.example.alunos.topografia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alunos.topografia.com.example.alunos.topografia.dominio.BancoDados;
import com.example.alunos.topografia.com.example.alunos.topografia.dominio.Planilha;

public class SalvarPontoActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_salvar_ponto);

        Intent it3 = getIntent();

        if(it3 != null){
            Bundle parametros3 = it3.getExtras();
            if(parametros3 != null){
                Integer posicao = parametros3.getInt("ponto_clicado");

                    Planilha p = BancoDados.basededados.get(posicao);   //nao seI

                }

            }


        inputNomeEstacao = (EditText) findViewById(R.id.txtAlterarEstacao);
        inputPontoVisado = (EditText) findViewById(R.id.txtAlterarVisado);

        inputGrauHorizontal = (EditText) findViewById(R.id.txtAlterarGrauHorizontal);
        inputMinHorizontal = (EditText) findViewById(R.id.txtAlterarMinutoHorizontal);
        inputSegHorizontal = (EditText) findViewById(R.id.txtAlterarSegundoHorizontal);

        inputFioSuperior = (EditText) findViewById(R.id.txtAlterarSuperior);
        inputFioMedio = (EditText) findViewById(R.id.txtAlterarMedio);
        inputFioInferior = (EditText) findViewById(R.id.txtAlterarInferior);

        inputGrauVertical = (EditText) findViewById(R.id.txtAlterarGrauVertical);
        inputMinVertical = (EditText) findViewById(R.id.txtAlterarMinutoVertical);
        inputSegVertical = (EditText) findViewById(R.id.txtAlterarSegundoVertical);

        inputAlturaAparelho = (EditText) findViewById(R.id.txtAlterarAltura);

    }

    public void salvarCampos(){

        Planilha p  = new Planilha(); //arrumar

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

    public void alterarPonto(View v) {

        salvarCampos();
        Intent it = new Intent(this, PontosActivity.class);
        startActivity(it);
    }

    public void excluirPonto(View v){
        //BancoDados.basededados.remove(p);  //remover do banco de dados
        Intent it = new Intent(this, PontosActivity.class);
        startActivity(it);

    }


}
