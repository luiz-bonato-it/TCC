package br.com.gerenciadorAulas.facade;

import java.util.List;

import br.com.gerenciadorAulas.bo.UsuarioBusiness;
import br.com.gerenciadorAulas.entity.Usuario;
import br.com.gerenciadorAulas.exception.AppValidateBusinessException;

public class GerenciadorAulasFacade {

	public void cadastrarUsuario(Usuario usuario) throws AppValidateBusinessException {
			new UsuarioBusiness().validateAndSave(usuario);
	}

	public List<Usuario> listarUsuarios() {
		return new UsuarioBusiness().listarRegistros();
	}
	
	public Usuario getUsuarioById(Long id) throws AppValidateBusinessException{
		return new UsuarioBusiness().getUsuarioById(id);
	}
	
	public void removerUsuarioById(Long id) throws AppValidateBusinessException {
		new UsuarioBusiness().remove(id);
	}
}
