/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.TipoQuestaoDAO;
import com.mycompany.enade.model.Tipoquestao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Octávio
 */
@Named
@ViewScoped
public class TipoQuestaoController implements Serializable {

    Tipoquestao tipoQuestao = new Tipoquestao();
    List<Tipoquestao> tipoQuestoes = new ArrayList<>();

    public TipoQuestaoController() {
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodos();
        tipoQuestao = new Tipoquestao();
    }

    public void gravar(ActionEvent actionEvent) {
        TipoQuestaoDAO.getInstance().merge(tipoQuestao);
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodos();
        tipoQuestao = new Tipoquestao();
    }
    
    public void remover(ActionEvent actionEvent) {
        TipoQuestaoDAO.getInstance().remover(tipoQuestao.getIdTipoQuestao());
        tipoQuestoes = TipoQuestaoDAO.getInstance().buscarTodos();
        tipoQuestao = new Tipoquestao();
    }

    public Tipoquestao getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(Tipoquestao tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public List<Tipoquestao> getTipoQuestoes() {
        return tipoQuestoes;
    }

    public void setTipoQuestoes(List<Tipoquestao> tipoQuestoes) {
        this.tipoQuestoes = tipoQuestoes;
    }
    
    
}
