/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Prova;

/**
 *
 * @author Octávio
 */
public class ProvaDAO extends GenericDAO<Prova, Integer> {
    
    public static ProvaDAO provaDAO;
    
    public ProvaDAO() {
        super(Prova.class);
    }
    
    public static ProvaDAO getInstance() {
        if (provaDAO == null) {
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }
   
}
