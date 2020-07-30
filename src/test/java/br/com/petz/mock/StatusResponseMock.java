package br.com.petz.mock;

import org.springframework.http.HttpStatus;

import br.com.petz.commons.healthcheck.StatusResponse;

public class StatusResponseMock {	

	public StatusResponse testStatus() {
		StatusResponse status = new StatusResponse(null, null);
		status.setMessage("Teste");
		status.setHttp(HttpStatus.OK);
		return status;
	}	

}