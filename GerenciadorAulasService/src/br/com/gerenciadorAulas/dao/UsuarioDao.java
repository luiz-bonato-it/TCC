package br.com.gerenciadorAulas.dao;

import br.com.gerenciadorAulas.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> implements InterfaceDao<Usuario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioDao() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

}
