package com.jms.guardiaoDoMarAPI.Model;

public class ResponseWebSocket {

	Object json;
	String modelJson;
		
	public ResponseWebSocket(Object json, String modelJson) {
		this.json = json;
		this.modelJson = modelJson;
	}

	public Object getJson() {
		return json;
	}

	public void setJson(Object json) {
		this.json = json;
	}

	public String getModelJson() {
		return modelJson;
	}

	public void setModelJson(String modelJson) {
		this.modelJson = modelJson;
	}		
}
