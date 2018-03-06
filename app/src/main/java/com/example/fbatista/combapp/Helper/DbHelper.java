package com.example.fbatista.combapp.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by fbatista on 06/03/18.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Abastecimentos.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABELA_ABASTECIMENTOS = "Abastecimentos";

    //Codigos SQL
    private static final String SQL_CRIAR_TABELA_ABASTECIMENTOS = "" +
            "CREATE TABLE " + TABELA_ABASTECIMENTOS + "(" +
            "id INTEGER PRIMARY_KEY AUTO_INCREMENT, " +
            "data TEXT," +
            "numeroFrota TEXT, " +
            "placa TEXT, " +
            "contador TEXT, " +
            "tipoCombustivel TEXT, " +
            "quantidade TEXT, " +
            "valor TEXT, " +
            "nomePosto TEXT, " +
            "nomeMototista TEXT, " +
            "nomeFrentista TEXT )";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{
            db.execSQL(SQL_CRIAR_TABELA_ABASTECIMENTOS);
            Log.e("Bancodedados", "Banco de dados criado com sucesso!");
        }catch (Exception e){
            Log.e("Bancodedados", "Erro ao criar o banco :/ " + e.getMessage());
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
