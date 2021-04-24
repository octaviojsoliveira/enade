/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.ResultadoDAO;
import com.mycompany.enade.model.Resultado;
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
@Path("resultado")
public class ResultadoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todosResultados")
    public List<Resultado> TodosResultados() {
        List<Resultado> entityList = ResultadoDAO.getInstance().buscarTodos();
        return entityList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscar/(idResultado)")
    public Resultado find(@PathParam("idResultado") Integer idResultado) {
        return ResultadoDAO.getInstance().buscar(idResultado);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/(idResultado)")
    public String Excluir(@PathParam("idResultado") Integer idResultado) {
        try {
            ResultadoDAO.getInstance().remover(idResultado);
            return "Registro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluirTodos")
    public String ExcluirTodos() {
        try {
            ResultadoDAO.getInstance().removerTodos();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String Cadastrar(Resultado entity) {
        Resultado r = new Resultado();
        try {
            r.setIdResultado(entity.getIdResultado());
            r.setValorObtido(entity.getValorObtido());
            r.setProvaidProva(entity.getProvaidProva());
            r.setUsuarioidUsuario(entity.getUsuarioidUsuario());
            ResultadoDAO.getInstance().merge(entity).toString();
            return "Registro cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro! " + e.getMessage();
        }
    }
}
