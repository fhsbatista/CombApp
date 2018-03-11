package com.dev.fbatista.combapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dev.fbatista.combapp.Model.Abastecimento;
import com.dev.fbatista.combapp.R;

import java.util.List;

/**
 * Created by fbatista on 04/03/18.
 */

public class AbastecimentoAdapter extends RecyclerView
        .Adapter<AbastecimentoAdapter.MyViewHolder> {

    private List<Abastecimento> listaAbastecimentos;


    public AbastecimentoAdapter(List<Abastecimento> listaAbastecimentos) {
        this.listaAbastecimentos = listaAbastecimentos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.lista_abastecimento, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Abastecimento abastecimento = listaAbastecimentos.get(position);
        holder.data.setText(abastecimento.getData());
        holder.numeroFrota.setText(abastecimento.getNumeroFrota());
        holder.nomePosto.setText(abastecimento.getNomePosto());

    }

    @Override
    public int getItemCount() {
        return listaAbastecimentos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView data;
        TextView numeroFrota;
        TextView nomePosto;


        public MyViewHolder(View itemView) {
            super(itemView);

            data = itemView.findViewById(R.id.tv_data);
            numeroFrota = itemView.findViewById(R.id.tv_numero_frota);
            nomePosto = itemView.findViewById(R.id.tv_nome_posto);
        }
    }
}
