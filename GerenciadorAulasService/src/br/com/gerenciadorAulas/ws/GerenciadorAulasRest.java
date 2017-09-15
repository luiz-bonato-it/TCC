package br.com.gerenciadorAulas.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.gerenciadorAulas.entity.Usuario;
import br.com.gerenciadorAulas.exception.AppValidateBusinessException;
import br.com.gerenciadorAulas.facade.GerenciadorAulasFacade;
import br.com.gerenciadorAulas.util.Message;

@Path("/gerenciadorAulasRest")
public class GerenciadorAulasRest {
	@POST
	@Path("/salvarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public void cadastrarStatus(Usuario usuario) throws AppValidateBusinessException{
		new GerenciadorAulasFacade().cadastrarUsuario(usuario);
	}
	
	@GET
	@Path("/listarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuario> listarUsuarios(){
		List<Usuario> retorno = new GerenciadorAulasFacade().listarUsuarios(); 
		return (ArrayList<Usuario>) retorno;
	}
	
	@GET
	@Path("/findUsuarioById")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarUsuarioById(@QueryParam("idUsuario")Long id) throws AppValidateBusinessException{
		Usuario retorno = new GerenciadorAulasFacade().getUsuarioById(id);
		return retorno;
	}
	
	@GET
	@Path("/removeUsuarioById")
	@Produces(MediaType.APPLICATION_JSON)
	public Message removeUsuarioById(@QueryParam("idUsuario")Long id) throws AppValidateBusinessException{
		new GerenciadorAulasFacade().removerUsuarioById(id);
		Message message = new Message();
		message.setMessage("Registro Excluido com sucesso");
		message.setStatusCode(1);
		return message;
	}

}
