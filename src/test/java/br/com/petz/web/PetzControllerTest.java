package br.com.petz.web;

import static org.junit.Assert.assertEquals;

import javax.management.relation.RoleInfoNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.petz.commons.healthcheck.HealthCheck;
import br.com.petz.commons.healthcheck.StatusResponse;
import br.com.petz.controller.PetzController;
import br.com.petz.mock.PetzMock;
import br.com.petz.service.PetzService;

@RunWith(SpringJUnit4ClassRunner.class)
public class PetzControllerTest extends PetzMock {

	@InjectMocks
	PetzController petzController;

	@Mock
	PetzService petzService;

	@Test
	public void testPetzController() throws RoleInfoNotFoundException {

		String message = "The service is ready...";
		StatusResponse statusResponse = new StatusResponse(message, HttpStatus.OK);
		HealthCheck healthCheck = new HealthCheck(true, statusResponse);
		@SuppressWarnings("unused")
		String id = "GCB_F7_ARQ_MTM_001";

		ResponseEntity<?> responseArquivos = petzController.createCliente(null);
		assertEquals("should be same status code", healthCheck.getStatus().getHttp(), responseArquivos.getStatusCode());
		id = "GCB_F7_ARQ_MTM_001";

	}
}