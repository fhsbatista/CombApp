package com.example.fbatista.combapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fbatista.combapp.Adapter.AbastecimentoAdapter;
import com.example.fbatista.combapp.Helper.AbastecimentoDAO;
import com.example.fbatista.combapp.Helper.DbHelper;
import com.example.fbatista.combapp.Model.Abastecimento;
import com.example.fbatista.combapp.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AbastecimentoAdapter abastecimentoAdapter;
    private List<Abastecimento> listaAbastecimento = new ArrayList<>();

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


        carregarListaAbastecimento();



    }

    public void carregarListaAbastecimento(){

        //Recuperando dados
        AbastecimentoDAO abastecimentoDAO = new AbastecimentoDAO(getApplicationContext());
        listaAbastecimento = abastecimentoDAO.listar();

        //Configurando o adapter
        abastecimentoAdapter = new AbastecimentoAdapter(listaAbastecimento);

        //Configurando o recycler view
        recyclerView = findViewById(R.id.recyclerView);
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
        carregarListaAbastecimento();
    }
}
