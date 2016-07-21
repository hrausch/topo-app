package com.example.alunos.topografia;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alunos.topografia.com.example.alunos.topografia.dominio.BancoDados;
import com.example.alunos.topografia.com.example.alunos.topografia.dominio.Planilha;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EstacoesActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView estacoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estacoes);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, BancoDados.listaEstacoes);

        estacoes = (ListView) findViewById(R.id.listView);

        estacoes.setAdapter(adaptador);
        estacoes.setOnItemClickListener(this);
    }


    @Override
    public void onResume() {

        super.onResume();


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, BancoDados.listaEstacoes);

        estacoes = (ListView) findViewById(R.id.listView);

        estacoes.setAdapter(adaptador);
        //   estacoes.setOnItemClickListener(this);

    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String p = (String) estacoes.getAdapter().getItem(position);
        Toast.makeText(this, p, Toast.LENGTH_SHORT).show();



        Intent it = new Intent(this, PontosActivity.class);

        Bundle parametros = new Bundle();
        parametros.putString("estacao_clicada", p);
        it.putExtras(parametros);

        startActivity(it);

    }
    public void abrirPlanilha(View v) {

        Intent it = new Intent(this, PreencherPlanilhaActivity.class);
        startActivity(it);
    }

    public void exportarArquivo(View v) {

        //Cria um arquivo.txt na pasta downloads
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "arquivo.txt");

        FileOutputStream outputStream;

        try {
            //cria um outputstream no arquivo no modo append
            outputStream = new FileOutputStream(file,true);


            String out = "";
            for(Planilha p : BancoDados.basededados) {
                outputStream.write( p.toString().getBytes() );
            }
            Toast.makeText(this, "Dados Exportados", Toast.LENGTH_SHORT).show();

            //fecha o recurso
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Intent it = new Intent(this, PreencherPlanilhaActivity.class);
        //startActivity(it);
    }
}
