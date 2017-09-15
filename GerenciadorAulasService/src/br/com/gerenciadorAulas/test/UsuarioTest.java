package br.com.gerenciadorAulas.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.gerenciadorAulas.entity.Usuario;
import br.com.gerenciadorAulas.exception.AppValidateBusinessException;
import br.com.gerenciadorAulas.facade.GerenciadorAulasFacade;

public class UsuarioTest {
	@Test
	public void insertUserTest01() throws AppValidateBusinessException{
		Usuario usuario = new Usuario();
		usuario.setNome("Teste Inserção usuario 01");
		usuario.setLogin("Login");
		usuario.setSenha("Senha");
		usuario.setUsrRole("ROLE_TEST");
		
		new GerenciadorAulasFacade().cadastrarUsuario(usuario);
		
		Assert.assertEquals(usuario.getId() == null, false);
	}
	
	@Test
	public void insertUserTest02() throws AppValidateBusinessException{
		Usuario usuario = new Usuario();
		usuario.setNome("Teste Inserção usuario 02");
		usuario.setLogin("Login");
		usuario.setSenha("Senha");
		usuario.setUsrRole("ROLE_TEST");
		
		new GerenciadorAulasFacade().cadastrarUsuario(usuario);
		
		Assert.assertEquals(usuario.getId() == null, false);
	}
	
	@Test
	public void insertUserTest03() throws AppValidateBusinessException{
		Usuario usuario = new Usuario();
		usuario.setNome("Teste Inserção usuario 03");
		usuario.setLogin("Login");
		usuario.setSenha("Senha");
		usuario.setUsrRole("ROLE_TEST");
		
		new GerenciadorAulasFacade().cadastrarUsuario(usuario);
		
		Assert.assertEquals(usuario.getId() == null, false);
	}
}
