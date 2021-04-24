/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.model.Resultado;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Octávio
 */
@Named
@ViewScoped
public class ResultadoController implements Serializable {
    
    Resultado resultado = new Resultado();
    List<Resultado> resultados = new ArrayList<>();

    public ResultadoController() {
        resultados = ResultadoDAO.getInstance().buscarTodos();
        resultado = new Resultado();
    }

    public void gravar(ActionEvent actionEvent) {
        ResultadoDAO.getInstance().merge(resultado);
        resultados = ResultadoDAO.getInstance().buscarTodos();
        resultado = new Resultado();
    }
    
    public void remover(ActionEvent actionEvent) {
        ResultadoDAO.getInstance().remover(resultado.getIdResultado());
        resultados = ResultadoDAO.getInstance().buscarTodos();
        resultado = new Resultado();
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<Resultado> getQuestoes() {
        return resultados;
    }

    public void setQuestoes(List<Resultado> questoes) {
        this.resultados = questoes;
    }
    
    
}
