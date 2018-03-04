package com.example.fbatista.combapp.Model;

/**
 * Created by fbatista on 04/03/18.
 */

public class Abastecimento {


    private String data;
    private String numeroFrota;
    private String placa;
    private String contador;
    private String tipoCombustivel;
    private String quantidade;
    private String valor;
    private String nomePosto;
    private String nomeMotorista;
    private String nomeFrentista;

    public Abastecimento(String data, String numeroFrota, String placa,
                         String contador, String tipoCombustivel, String quantidade,
                         String valor, String nomePosto, String nomeMotorista,
                         String nomeFrentista) {
        this.data = data;
        this.numeroFrota = numeroFrota;
        this.placa = placa;
        this.contador = contador;
        this.tipoCombustivel = tipoCombustivel;
        this.quantidade = quantidade;
        this.valor = valor;
        this.nomePosto = nomePosto;
        this.nomeMotorista = nomeMotorista;
        this.nomeFrentista = nomeFrentista;
    }
}
