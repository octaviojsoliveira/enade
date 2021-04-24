/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Usuario;

/**
 *
 * @author Octávio
 */ 
public class UsuarioDAO extends GenericDAO<Usuario, Integer> {
    
    public static UsuarioDAO usuarioDAO;
    
    public UsuarioDAO() {
        super(Usuario.class);
    }
    
    public static UsuarioDAO getInstance(){
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }
    
}
