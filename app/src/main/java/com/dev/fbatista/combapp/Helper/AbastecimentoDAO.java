package com.dev.fbatista.combapp.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.dev.fbatista.combapp.Model.Abastecimento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fbatista on 06/03/18.
 */

public class AbastecimentoDAO implements IAbastecimentoDAO{

    private SQLiteDatabase escreve;
    private SQLiteDatabase le;
    private Context context;

    public AbastecimentoDAO(Context context) {

        DbHelper db = new DbHelper(context);
        this.context = context;

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
           Toast.makeText(context, "Sucesso ao salvar o abastecimento!", Toast.LENGTH_SHORT).show();



        }catch (Exception e){
            Log.e("Bancodedados", "Erro ao salvar o abastecimento " + e.getMessage());
            return false;
        }
     return true;
    }

    @Override
    public boolean atualizar(Abastecimento abastecimento) {



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
            String[] args = {abastecimento.getId().toString()};
            escreve.update(DbHelper.TABELA_ABASTECIMENTOS, cv, "id=?", args );
            Log.i("Bancodedados", "Sucesso ao atualizar o abastecimento.");
            Toast.makeText(context, "Sucesso ao atualizar o abastecimento!", Toast.LENGTH_SHORT).show();



        }catch (Exception e){
            Log.i("Bancodedados", "Erro ao atualizar o abastecimento " + e.getMessage());
            return false;
        }


        return true;
    }

    @Override
    public boolean deletar(Abastecimento abastecimento) {
        

        try{
            String[] args = {abastecimento.getId().toString()};
            escreve.delete(DbHelper.TABELA_ABASTECIMENTOS, "id=?", args);
            Toast.makeText(context, "Registro removido com sucesso!", Toast.LENGTH_SHORT).show();
            
            
            Log.i("Bancodedados", "Sucesso ao remover o abastecimento" );
        }catch (Exception e){
            Log.i("Bancodedados", "Erro ao remover o abastecimento" + e.getMessage());
        }
        
        
        
        return true;
    }

    @Override
    public List<Abastecimento> listar() {

        List<Abastecimento> listaAbastecimentos = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_ABASTECIMENTOS + " ;";
        Cursor c = le.rawQuery(sql, null);
        c.moveToPosition(c.getCount() + 1);
        while(c.moveToPrevious()){
            Abastecimento abastecimento = new Abastecimento();
            abastecimento.setId(c.getLong(c.getColumnIndex("id")));
            abastecimento.setData(c.getString(c.getColumnIndex("data")));
            abastecimento.setNumeroFrota(c.getString(c.getColumnIndex("numeroFrota")));
            abastecimento.setPlaca(c.getString(c.getColumnIndex("placa")));
            abastecimento.setContador(c.getString(c.getColumnIndex("contador")));
            abastecimento.setTipoCombustivel(c.getString(c.getColumnIndex("tipoCombustivel")));
            abastecimento.setQuantidade(c.getString(c.getColumnIndex("quantidade")));
            abastecimento.setValor(c.getString(c.getColumnIndex("valor")));
            abastecimento.setNomePosto(c.getString(c.getColumnIndex("nomePosto")));
            abastecimento.setNomeMotorista(c.getString(c.getColumnIndex("nomeMotorista")));
            abastecimento.setNomeFrentista(c.getString(c.getColumnIndex("nomeFrentista")));

            listaAbastecimentos.add(abastecimento);




        }
        c.close();



        return listaAbastecimentos;
    }
}
