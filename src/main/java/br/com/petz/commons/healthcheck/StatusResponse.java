package br.com.petz.commons.healthcheck;

import java.io.Serializable;

import org.springframework.http.HttpStatus;


public class StatusResponse implements Serializable{

	private static final long serialVersionUID = 42L;
	
	private String message;
	private HttpStatus http;
	
	public StatusResponse(String message, HttpStatus http) {
		this.message = message;
		this.http = http;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttp() {
		return http;
	}

	public void setHttp(HttpStatus http) {
		this.http = http;
	}
}