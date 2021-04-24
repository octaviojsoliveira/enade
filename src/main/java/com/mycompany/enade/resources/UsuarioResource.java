/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.UsuarioDAO;
import com.mycompany.enade.model.Usuario;
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
@Path("usuario")
public class UsuarioResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("todosUsuario")
    public List<Usuario> TodosUsuario(){
        List<Usuario> entityList = UsuarioDAO.getInstance().buscarTodos();
        return entityList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscar/(idUsuario)")
    public Usuario find(@PathParam("idUsuario") Integer idUsuario) {
        return UsuarioDAO.getInstance().buscar(idUsuario);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/(idUsuario)")
    public String Excluir(@PathParam("idUsuario") Integer idUsuario){
        try{
            UsuarioDAO.getInstance().remover(idUsuario);
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
            UsuarioDAO.getInstance().removerTodos();
            return "Todos os registros exxcluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String Cadastrar(Usuario entity) {
        Usuario u = new Usuario();
        try{
            u.setIdUsuario(entity.getIdUsuario());
            u.setNome(entity.getNome());
            u.setEmail(entity.getEmail());
            u.setSenha(entity.getSenha());            
            u.setTipoUsuarioidTipoUsuario(entity.getTipoUsuarioidTipoUsuario());
            UsuarioDAO.getInstance().merge(entity).toString();
            return "Registro cadastrado com suceso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }
    
}
