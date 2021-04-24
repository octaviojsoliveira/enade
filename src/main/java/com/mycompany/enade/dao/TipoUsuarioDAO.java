/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Tipousuario;

/**
 *
 * @author Octávio
 */
public class TipoUsuarioDAO extends GenericDAO<Tipousuario, Integer> {
    
     public static TipoUsuarioDAO tipoUsuarioDAO;
    
     public TipoUsuarioDAO() {
         super(Tipousuario.class);
     }
     
     public static TipoUsuarioDAO getInstance() {
         if (tipoUsuarioDAO == null) {
             tipoUsuarioDAO = new TipoUsuarioDAO();
         }
         return tipoUsuarioDAO;
     }
}
