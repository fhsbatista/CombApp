package com.example.fbatista.combapp.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.fbatista.combapp.Model.Abastecimento;

import java.util.List;

/**
 * Created by fbatista on 06/03/18.
 */

public class AbastecimentoDAO implements IAbastecimentoDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;

    public AbastecimentoDAO(Context context) {

        DbHelper db = new DbHelper(context);

        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Abastecimento abastecimento) {

        ContentValues cv = new ContentValues();
        cv.put("data", abastecimento.getData());
        cv.put("numeroFrota", abastecimento.getNumeroFrota());
        cv.put("placa", abastecimento.getPlaca());
        cv.put("contador", abastecimento.getContador());
        cv.put("tipoCombustivel", abastecimento.getTipoCombustivel());
        cv.put("quantidade", abastecimento.getQuantidade());
        cv.put("valor", abastecimento.getValor());
        cv.put("nomePosto", abastecimento.getNomePosto());
        cv.put("nomeMotorista", abastecimento.getNomeMotorista());
        cv.put("nomeFrentista", abastecimento.getNomeFrentista());

        try{

           escreve.insert(DbHelper.TABELA_ABASTECIMENTOS, null, cv);
           Log.e("Bancodedados", "Dado de Abastecimento inserido com sucesso");


        }catch (Exception e){
            Log.e("Bancodedados", "Erro ao salvar o abastecimento " + e.getMessage());
            return false;
        }
     return true;
    }

    @Override
    public boolean alterar(Abastecimento abastecimento) {
        return false;
    }

    @Override
    public boolean deletar(Abastecimento abastecimento) {
        return false;
    }

    @Override
    public List<Abastecimento> listar() {
        return null;
    }
}
