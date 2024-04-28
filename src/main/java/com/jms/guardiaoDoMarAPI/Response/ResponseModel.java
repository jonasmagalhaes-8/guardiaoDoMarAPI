package com.jms.guardiaoDoMarAPI.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseModel {
	private Object response;
	private String mensagem;
	
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public ResponseModel(String mensagem) {
		this.mensagem = mensagem;
	}
	public ResponseModel(Object response, String mensagem) {
		this.response = response;
		this.mensagem = mensagem;
	}	
}