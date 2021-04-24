/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.resources;

import com.mycompany.enade.dao.QuestaoDAO;
import com.mycompany.enade.model.Questao;
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
@Path("questao")
public class QuestaoResource {
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("todasQuestoes")
    public List<Questao> TodasQuestoes(){
        List<Questao> entityList = QuestaoDAO.getInstance().buscarTodos();
        return entityList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscar/(idQuestao)")
    public Questao find(@PathParam("idQuestao") Integer idQuestao){

        return QuestaoDAO.getInstance().buscar(idQuestao);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/(idQuestao)")
    public String Excluir(@PathParam("idQuestao") Integer idQuestao){
        try{
            QuestaoDAO.getInstance().remover(idQuestao);
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
            QuestaoDAO.getInstance().removerTodos();
            return "Todos os registros exxcluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String Cadastrar(Questao entity) {
        Questao q = new Questao();
        try{
            q.setIdQuestao(entity.getIdQuestao());
            q.setAlternativaA(entity.getAlternativaA());
            q.setAlternativaB(entity.getAlternativaB());
            q.setAlternativaC(entity.getAlternativaC());
            q.setAlternativaD(entity.getAlternativaD());
            q.setAlternativaE(entity.getAlternativaE());
            q.setDescricaoQuestao(entity.getDescricaoQuestao());
            q.setQuestaoCorreta(entity.getQuestaoCorreta());
            q.setEstadoQuestao(entity.getEstadoQuestao());
            q.setTipoQuestaoidTipoQuestao(entity.getTipoQuestaoidTipoQuestao());
            q.setProvaList(entity.getProvaList());
            QuestaoDAO.getInstance().merge(entity).toString();
            return "Registro cadastrado com suceso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }
}
