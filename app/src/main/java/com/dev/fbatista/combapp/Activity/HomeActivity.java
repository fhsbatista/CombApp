package com.dev.fbatista.combapp.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.dev.fbatista.combapp.Adapter.AbastecimentoAdapter;
import com.dev.fbatista.combapp.Helper.AbastecimentoDAO;
import com.dev.fbatista.combapp.Model.Abastecimento;
import com.dev.fbatista.combapp.R;
import com.dev.fbatista.combapp.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AbastecimentoAdapter abastecimentoAdapter;
    private List<Abastecimento> listaAbastecimento = new ArrayList<>();
    private Abastecimento abastecimentoSelecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        //Configurando o click na recycler view
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Abastecimento abastecimento = listaAbastecimento.get(position);

                                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                                intent.putExtra("abastecimento", abastecimento);
                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                //Recupera o abastecimento selecionado
                                abastecimentoSelecionado = listaAbastecimento.get(position);

                                //Cria o alertdialog
                                AlertDialog.Builder dialog = new AlertDialog.Builder(HomeActivity.this);
                                dialog.setTitle("Confirmar Exclusao");
                                dialog.setMessage("Deseja excluir este abastecimento?");

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        AbastecimentoDAO abastecimentoDAO = new AbastecimentoDAO(getApplicationContext());
                                        abastecimentoDAO.deletar(abastecimentoSelecionado);
                                        carregarListaAbastecimento();

                                    }
                                });

                                dialog.setNegativeButton("Nao", null);

                                //Cria e exibe a dialog
                                dialog.create();
                                dialog.show();


                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );







    }

    public void carregarListaAbastecimento(){

        //Recuperando dados
        AbastecimentoDAO abastecimentoDAO = new AbastecimentoDAO(getApplicationContext());
        listaAbastecimento = abastecimentoDAO.listar();

        //Configurando o adapter
        abastecimentoAdapter = new AbastecimentoAdapter(listaAbastecimento);

        //Configurando o recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                LinearLayout.VERTICAL));
        recyclerView.setAdapter(abastecimentoAdapter);




    }

    @Override
    protected void onStart() {
        super.onStart();
        listaAbastecimento.clear();
        carregarListaAbastecimento();
    }
}
