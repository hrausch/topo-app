package com.example.alunos.topografia;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alunos.topografia.com.example.alunos.topografia.dominio.BancoDados;
import com.example.alunos.topografia.com.example.alunos.topografia.dominio.Planilha;

import java.util.ArrayList;

public class PontosActivity extends ListActivity {

    ArrayList<String> listItems = new ArrayList<String>();
    ArrayList<Integer> listPosition = new ArrayList<Integer>();

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent it2 = getIntent();

        if(it2 != null){
            Bundle parametros2 = it2.getExtras();
            if(parametros2 != null){
                String nome = parametros2.getString("estacao_clicada");


                for( int i = 0; i < BancoDados.basededados.size(); i++){

                    Planilha p = BancoDados.basededados.get(i);
                    if(p.getNomeEstacao().equals(nome)){

                        listItems.add(p.getPontoVisado());
                        listPosition.add(i);

                    }

                }


            }
        }

        /*trabalhos futuros: implementar o proprio adapter*/
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);

    }

    @Override
    public void onResume() {

        super.onResume();


        Intent it2 = getIntent();

        if(it2 != null){
            Bundle parametros2 = it2.getExtras();
            if(parametros2 != null){
                String nome = parametros2.getString("estacao_clicada");


                for( int i = 0; i < BancoDados.basededados.size(); i++){

                    Planilha p = BancoDados.basededados.get(i);
                    if(p.getNomeEstacao().equals(nome)){

                        listItems.add(p.getPontoVisado());
                        listPosition.add(i);
                    }
                }
            }
        }

        /*trabalhos futuros: implementar o proprio adapter*/
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        setListAdapter(adapter);

    }


    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String p = (String) adapter.getItem(position);
        int posicaoBD = listPosition.get(position);
        Toast.makeText(this, "Estação " + p, Toast.LENGTH_SHORT).show();

        Intent it = new Intent(this, SalvarPontoActivity.class);

        Bundle parametros = new Bundle();
        parametros.putInt("ponto_clicado", posicaoBD);
        it.putExtras(parametros);

        startActivity(it);

    }

}
