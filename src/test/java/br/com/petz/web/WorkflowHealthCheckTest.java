package br.com.petz.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.petz.commons.healthcheck.HealthCheck;
import br.com.petz.commons.healthcheck.StatusResponse;
import br.com.petz.controller.WorkflowHealthCheck;
import br.com.petz.service.WorkFlowHealthCheckService;

@RunWith(SpringJUnit4ClassRunner.class)
public class WorkflowHealthCheckTest {

	@InjectMocks
	WorkflowHealthCheck workflowHealthCheck;

	@Mock
	WorkFlowHealthCheckService workflowHealthCheckService;

	@Test
	public void testHealthCheckLivenessOk() {

		String message = "The service is ready...";
		StatusResponse statusResponse = new StatusResponse(message, HttpStatus.OK);
		HealthCheck healthCheck = new HealthCheck(true, statusResponse);

		ResponseEntity<?> response = workflowHealthCheck.liveness();

		assertEquals("should be same status code", healthCheck.getStatus().getHttp(), response.getStatusCode());

	}

	@Test
	public void testHealthCheckReadinessOk() {

		String message = "The service is ready...";
		StatusResponse statusResponse = new StatusResponse(message, HttpStatus.OK);
		HealthCheck healthCheck = new HealthCheck(true, statusResponse);

		ResponseEntity<?> response = workflowHealthCheck.readiness();

		assertEquals("should be same status code", healthCheck.getStatus().getHttp(), response.getStatusCode());

	}

}