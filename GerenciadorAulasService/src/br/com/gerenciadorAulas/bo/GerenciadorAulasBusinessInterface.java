package br.com.gerenciadorAulas.bo;

import java.util.List;

import br.com.gerenciadorAulas.exception.AppValidateBusinessException;

public interface GerenciadorAulasBusinessInterface<T> {
	public void validateAndSave(T t)  throws AppValidateBusinessException;
	
	public List<T> listarRegistros() ;
}
