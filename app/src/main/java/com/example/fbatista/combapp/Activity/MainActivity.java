package com.example.fbatista.combapp.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fbatista.combapp.Model.Abastecimento;
import com.example.fbatista.combapp.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static String[] tiposCombustivel = new String[] {"Diesel Comum", "Diesel S10","Etanol", "Gasolina"};
    private AutoCompleteTextView mTipoCombustivel;
    private EditText mData;
    private EditText mNumeroFrota;
    private EditText mPlaca;
    private EditText mContador;
    private EditText mQuantidade;
    private EditText mValor;
    private EditText mNomePosto;
    private EditText mNomeMotorista;
    private EditText mNomeFrentista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Configura opçoes que estarao disponivels no campos de tipo de combustivel
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tiposCombustivel);
        mTipoCombustivel = findViewById(R.id.et_tipo_combustivel);
        mTipoCombustivel.setAdapter(adapter);


        mData = findViewById(R.id.et_data);
        mNumeroFrota = findViewById(R.id.et_numero_frota);
        mPlaca = findViewById(R.id.et_placa);
        mContador = findViewById(R.id.et_contador);
        mQuantidade = findViewById(R.id.et_quantidade);
        mValor = findViewById(R.id.et_valor);
        mNomePosto = findViewById(R.id.et_nome_posto);
        mNomeMotorista = findViewById(R.id.et_nome_motorista);
        mNomeFrentista = findViewById(R.id.et_nome_frentista);

        //Preenche o campo de data com a data corrente
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        mData.setText(dateFormat.format(date));


    }

    public void enviarEmail(Abastecimento abastecimento){

        StringBuilder sb = new StringBuilder();
        sb.append("Data: " + abastecimento.getData());
        sb.append("\nFrota: " + abastecimento.getNumeroFrota());
        sb.append("\nPlaca: " + abastecimento.getPlaca());
        sb.append("\nContador: " + abastecimento.getContador());
        sb.append("\nQuantidade: " + abastecimento.getQuantidade());
        sb.append("\nValor: " + abastecimento.getValor());
        sb.append("\nTipo Combustivel: " + abastecimento.getTipoCombustivel());
        sb.append("\nNome Posto: " + abastecimento.getNomePosto());
        sb.append("\nNome Motorista: " + abastecimento.getNomeMotorista());
        sb.append("\nNome Frentista: " + abastecimento.getNomeFrentista());
        sb.append("\n\nObrigado por utilizar o CombApp em seu negocio!");


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Frota: " + abastecimento.getNumeroFrota() + " - Informativo de abastecimento");
        intent.putExtra(Intent.EXTRA_TEXT, sb.toString());
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Escolha o app para enviar o informativo"));


    }

    public Abastecimento geraAbastecimento(){

        Abastecimento abastecimento = new Abastecimento(
                mData.getText().toString(),
                mNumeroFrota.getText().toString(),
                mPlaca.getText().toString(),
                mContador.getText().toString(),
                mTipoCombustivel.getText().toString(),
                mQuantidade.getText().toString(),
                mValor.getText().toString(),
                mNomePosto.getText().toString(),
                mNomeMotorista.getText().toString(),
                mNomeFrentista.getText().toString()
        );


        return abastecimento;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_novo_abastecimento, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.salvar :
                enviarEmail(geraAbastecimento());
                break;

        }



        return super.onOptionsItemSelected(item);
    }
}
