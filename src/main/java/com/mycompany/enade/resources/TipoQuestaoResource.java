package com.mycompany.enade.resources;

import com.mycompany.enade.dao.TipoQuestaoDAO;
import com.mycompany.enade.model.Tipoquestao;
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
@Path("tipoquestao")
public class TipoQuestaoResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/todosTipoQuestao")
    public List<Tipoquestao> TodosTipoQuestao(){
        List<Tipoquestao> entityList = TipoQuestaoDAO.getInstance().buscarTodos();
        return entityList;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/buscar/(idTipoQuestao)")
    public Tipoquestao find(@PathParam("idTipoQuestao") Integer idTipoQuestao){

        return TipoQuestaoDAO.getInstance().buscar(idTipoQuestao);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excluir/(idTipoQuestao)")
    public String Excluir(@PathParam("idTipoQuestao") Integer idTipoQuestao){
        try{
            Tipoquestao tipoQuestao = new Tipoquestao(idTipoQuestao);
            TipoQuestaoDAO.getInstance().remover(idTipoQuestao);
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
            TipoQuestaoDAO.getInstance().removerTodos();
            return "Todos os registros excluídos com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir o registro! " + e.getMessage();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/merge")
    public String Cadastrar(Tipoquestao entity) {
        Tipoquestao tp = new Tipoquestao();
        try{
            tp.setNomeTipoQuestao(entity.getNomeTipoQuestao());
            TipoQuestaoDAO.getInstance().merge(entity).toString();
            return "Registro cadastrado com suceso!";
        } catch (Exception e) {
            return "Erro ao cadastrar um registro " + e.getMessage();
        }
    }
    
}
