package br.com.petz.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.petz.commons.healthcheck.HealthCheck;
import br.com.petz.mock.StatusResponseMock;

@RunWith(SpringJUnit4ClassRunner.class)
public class HealthCheckTest {
	
	@Mock
	StatusResponseMock statusMock;
	
	@Test
	public void testHeathCheck() {
		HealthCheck heath = new HealthCheck(null, null);
		heath.setResult(true);
		heath.setStatus(statusMock.testStatus());
		
		Assert.assertNotNull(heath.getResult());
		Assert.assertEquals("should be same", heath.getStatus(), statusMock.testStatus());
		
	}

}
