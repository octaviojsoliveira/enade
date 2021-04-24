/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ProvaDAO;
import com.mycompany.enade.model.Prova;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Octávio
 */
@Path("prova")
public class ProvaResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todasProvas")
    public List<Prova> TodasProvas(){
        List<Prova> entityList = ProvaDAO.getInstance().buscarTodos();
        return entityList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscar/(idProva)")
    public Prova find(@PathParam("idProva") Integer idProva){

        return ProvaDAO.getInstance().buscar(idProva);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/(idProva)")
    public String Excluir(@PathParam("idProva") Integer idProva){
        try{
            ProvaDAO.getInstance().remover(idProva);
            return "Registro excluido com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluirTodas")
    public String ExcluirTodas(){
        try{
            ProvaDAO.getInstance().removerTodos();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String Cadastrar(Prova entity) {
        Prova p = new Prova();
        try{
            ProvaDAO.getInstance().merge(entity).toString();
            return "Registro cadastrado com suceso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }
        
}
