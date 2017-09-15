package br.com.gerenciadorAulas.dao;

import br.com.gerenciadorAulas.entity.Usuario;

public class FactoryDao {
	public static InterfaceDao<Usuario> getUsuarioDao(){
		return  new UsuarioDao();
	}
}
