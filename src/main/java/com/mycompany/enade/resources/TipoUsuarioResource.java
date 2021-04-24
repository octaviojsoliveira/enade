/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoUsuarioDAO;
import com.mycompany.enade.model.Tipousuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Octávio
 */
@Path("tipousuario")
public class TipoUsuarioResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todosTipoUsuario")
    public List<Tipousuario> TodosTipoUsuario(){
        List<Tipousuario> entityList = TipoUsuarioDAO.getInstance().buscarTodos();
        return entityList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscar/(idTipoUsuario)")
    public Tipousuario find(@PathParam("idTipoUsuario") Integer idTipoUsuario){

        return TipoUsuarioDAO.getInstance().buscar(idTipoUsuario);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/(idTipoUsuario)")
    public String Excluir(@PathParam("idTipoUsuario") Integer idTipoUsuario){
        try{
            Tipousuario tipoUsuario = new Tipousuario(idTipoUsuario, "");
            TipoUsuarioDAO.getInstance().remover(idTipoUsuario);
            return "Registro excluido com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluirTodos")
    public String ExcluirTodos(){
        try{
            TipoUsuarioDAO.getInstance().removerTodos();
            return "Todos os registros exxcluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String Cadastrar(Tipousuario entity) {
        Tipousuario tu = new Tipousuario();
        try{
            tu.setIdTipoUsuario(entity.getIdTipoUsuario());
            tu.setNomeTipoUsuario(entity.getNomeTipoUsuario());
            TipoUsuarioDAO.getInstance().merge(entity).toString();
            return "Registro cadastrado com suceso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }
    
}
