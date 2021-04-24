/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.model.Prova;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Octávio
 */
public class ProvaResourceTest {
    
    ProvaResource ProvaResource = mock(ProvaResource.class);
    List<Prova> ProvaList = new ArrayList<>();
    Prova Prova = mock(Prova.class);
    
    public ProvaResourceTest() {
    }
    
    @Test
    public void testBuscar(){
        when(ProvaResource.find(Prova.getIdProva())).thenReturn(Prova);
        assertEquals(Prova, ProvaResource.find(Prova.getIdProva()));
    }
    
    @Test
    public void testBuscarTodas(){
        ProvaList.add(Prova);
        when(ProvaResource.TodasProvas()).thenReturn(ProvaList);
        assertEquals(ProvaList, ProvaResource.TodasProvas());
    }
    
    @Test
    public void testExcluirTodas(){
        when(ProvaResource.ExcluirTodas()).thenReturn("Todos os registros excluídos com sucesso!");
        assertEquals("Todos os registros excluídos com sucesso!", ProvaResource.ExcluirTodas());
    }
    
    @Test
    public void testExcluir(){
        when(ProvaResource.Excluir(Prova.getIdProva())).thenReturn("Registro excluído com sucesso!");
        assertEquals("Registro excluído com sucesso!", ProvaResource.Excluir(Prova.getIdProva()));
    }
    
    @Test
    public void testMerge() {
        when(ProvaResource.Cadastrar(Prova)).thenReturn("Registro feito com sucesso");
        assertEquals("Registro feito com sucesso", ProvaResource.Cadastrar(Prova));
    }
}
