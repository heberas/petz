package br.com.petz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.commons.healthcheck.HealthCheck;
import br.com.petz.commons.healthcheck.StatusResponse;
import br.com.petz.service.WorkFlowHealthCheckService;

@RequestMapping
@RestController
public class WorkflowHealthCheck {
	
	private static final Boolean TRUE = Boolean.TRUE;

	private static final Boolean FALSE = Boolean.FALSE;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = true)
	private WorkFlowHealthCheckService workFlowHealthCheckService;

	public WorkflowHealthCheck() {
		// Auto-generated constructor stub
	}
	
	@GetMapping(value = "/readiness", produces = "application/json")
	public ResponseEntity<HealthCheck> readiness() {

		try {

			workFlowHealthCheckService.readiness();

			return ResponseEntity
					.ok(new HealthCheck(TRUE, new StatusResponse("The service is ready...", HttpStatus.OK)));

		} catch (Exception e) {
			logger.error("Nao foi encontrado a ultima execução: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HealthCheck(FALSE,
					new StatusResponse("The service is not ready...", HttpStatus.INTERNAL_SERVER_ERROR)));
		}
	}

	@GetMapping(value = "/liveness", produces = "application/json")
	public ResponseEntity<HealthCheck> liveness() {

		try {

			workFlowHealthCheckService.liveness();

			return ResponseEntity
					.ok(new HealthCheck(TRUE, new StatusResponse("The service is ready...", HttpStatus.OK)));

		} catch (Exception e) {
			logger.error("Nao foi encontrado a ultima execução: ", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HealthCheck(FALSE,
					new StatusResponse("The service is not ready...", HttpStatus.INTERNAL_SERVER_ERROR)));
		}
	}

}