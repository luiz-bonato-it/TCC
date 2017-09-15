package br.com.gerenciadorAulas.util;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String message;
	private Integer statusCode;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
