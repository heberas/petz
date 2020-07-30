package br.com.petz.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.petz.commons.healthcheck.StatusResponse;
import br.com.petz.mock.StatusResponseMock;

@RunWith(SpringJUnit4ClassRunner.class)
public class StatusResponseTest {
	
		@Mock
		StatusResponseMock statusMock;
		
		@Test
		public void testStatus() {
			StatusResponse status = new StatusResponse(null, null);
			status.setMessage("Teste");
			status.setHttp(HttpStatus.OK);
			
			Assert.assertNotNull(status.getMessage());
			Assert.assertNotNull(status.getHttp());
		}

}