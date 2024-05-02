package com.jms.guardiaoDoMarAPI.Model;

public class ResponseWebSocket {

	Object json;
	String modelJson;
		
	public ResponseWebSocket(Object json, String modelJson) {
		this.json = json;
		this.modelJson = modelJson;
	}	
}
