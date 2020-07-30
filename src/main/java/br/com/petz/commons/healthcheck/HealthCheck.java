package br.com.petz.commons.healthcheck;

import java.io.Serializable;

public class HealthCheck implements Serializable {

	private static final long serialVersionUID = -1857376625521365176L;
	private Boolean result;
	private StatusResponse status;
	
	public HealthCheck(Boolean result, StatusResponse status) {
		this.result = result;
		this.status = status;
	}

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public StatusResponse getStatus() {
		return status;
	}

	public void setStatus(StatusResponse status) {
		this.status = status;
	}
	
}