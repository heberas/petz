package br.com.petz.mock;

import br.com.petz.commons.healthcheck.HealthCheck;
import br.com.petz.commons.healthcheck.StatusResponse;

public class HealthCheckMock {
	
	
	public HealthCheck testHealthCheck(){
		HealthCheck health = new HealthCheck(null, null);
		health.setResult(true);
		health.setStatus(new StatusResponse(null, null));
		return health;
	}
}