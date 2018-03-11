package com.dev.fbatista.combapp.Helper;

import com.dev.fbatista.combapp.Model.Abastecimento;

import java.util.List;

/**
 * Created by fbatista on 06/03/18.
 */

public interface IAbastecimentoDAO {

    public boolean salvar(Abastecimento abastecimento);
    public boolean atualizar(Abastecimento abastecimento);
    public boolean deletar(Abastecimento abastecimento);
    public List<Abastecimento> listar();
}
