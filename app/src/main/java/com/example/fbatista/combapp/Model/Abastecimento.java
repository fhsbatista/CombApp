package com.example.fbatista.combapp.Model;

import java.io.Serializable;

/**
 * Created by fbatista on 04/03/18.
 */

public class Abastecimento implements Serializable {


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

    public String getData() {
        return data;
    }

    public String getNumeroFrota() {
        return numeroFrota;
    }

    public String getPlaca() {
        return placa;
    }

    public String getContador() {
        return contador;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getValor() {
        return valor;
    }

    public String getNomePosto() {
        return nomePosto;
    }

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public String getNomeFrentista() {
        return nomeFrentista;
    }
}
