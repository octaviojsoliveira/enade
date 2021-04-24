/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Tipoquestao;

/**
 *
 * @author Octávio
 */
public class TipoQuestaoDAO extends GenericDAO<Tipoquestao, Integer> {
    
    public static TipoQuestaoDAO tipoQuestaoDAO;
    
    public TipoQuestaoDAO() {
        super(Tipoquestao.class);
    }
    
    public static TipoQuestaoDAO getInstance() {
        if (tipoQuestaoDAO == null) {
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }
    
}
