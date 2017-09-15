package br.com.gerenciadorAulas.exception;

public class AppValidateBusinessException extends Exception {
	// Parameterless Constructor
    public AppValidateBusinessException() {}

    // Constructor that accepts a message
    public AppValidateBusinessException(String message)
    {
       super(message);
    }
}
