package br.com.gerenciadorAulas.bo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.com.gerenciadorAulas.dao.FactoryDao;
import br.com.gerenciadorAulas.entity.Usuario;
import br.com.gerenciadorAulas.exception.AppValidateBusinessException;

public class UsuarioBusiness implements GerenciadorAulasBusinessInterface<Usuario> {

	@Override
	public void validateAndSave(Usuario t) throws AppValidateBusinessException {
		if (StringUtils.isEmpty(t.getNome())) {
			throw new AppValidateBusinessException("Problema ao validar Usuario, um usuario deve conter um nome cadastrado!");
		}
		
		if (StringUtils.isEmpty(t.getLogin())) {
			throw new AppValidateBusinessException("Problema ao validar Usuario, um usuario deve conter um login cadastrado!");
		}
		
		if (StringUtils.isEmpty(t.getSenha())) {
			throw new AppValidateBusinessException("Problema ao validar Usuario, um usuario deve conter uma senha cadastrada!");
		}
		
		if (StringUtils.isEmpty(t.getUsrRole())) {
			throw new AppValidateBusinessException("Problema ao validar Usuario, um usuario deve conter um nível de acesso cadastrado!");
		}

		if (t.getId() != null) {
			FactoryDao.getUsuarioDao().update(t);
		} else {
			t.setAtivo(1);
			FactoryDao.getUsuarioDao().save(t);
		}

	}

	@Override
	public List<Usuario> listarRegistros() {
		return FactoryDao.getUsuarioDao().listar();
	}
	
	public Usuario getUsuarioById (Long id) throws AppValidateBusinessException{
		
		if (id == null){
			throw new AppValidateBusinessException("Problema ao validar consulta, um Id deve ser informado.");
		}
		
		return FactoryDao.getUsuarioDao().findById(id);
	}

	
	public void remove(Long id) throws AppValidateBusinessException {
		if (id == null) {
			throw new AppValidateBusinessException("Problema ao validar remoção, o id deve ser informado");
		}
		
		FactoryDao.getUsuarioDao().remove(id);
	}
	

}
