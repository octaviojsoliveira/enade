/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.controller;

import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.Tipousuario;
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
public class TipoUsuarioController implements Serializable {
    
    Tipousuario tipoUsuario = new Tipousuario();
    List<Tipousuario> tipoUsuarios = new ArrayList<>();

    public TipoUsuarioController() {
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodos();
        tipoUsuario = new Tipousuario();
    }

    public void gravar(ActionEvent actionEvent) {
        TipoUsuarioDAO.getInstance().merge(tipoUsuario);
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodos();
        tipoUsuario = new Tipousuario();
    }
    
    public void remover(ActionEvent actionEvent) {
        TipoUsuarioDAO.getInstance().remover(tipoUsuario.getIdTipoUsuario());
        tipoUsuarios = TipoUsuarioDAO.getInstance().buscarTodos();
        tipoUsuario = new Tipousuario();
    }

    public Tipousuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Tipousuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Tipousuario> getTipousuario() {
        return tipoUsuarios;
    }

    public void setTipousuario(List<Tipousuario> tipousuario) {
        this.tipoUsuarios = tipousuario;
    }
    
    
}
