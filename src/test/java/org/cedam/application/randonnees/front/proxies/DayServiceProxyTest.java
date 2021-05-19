package org.cedam.application.randonnees.front.proxies;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DayServiceProxyTest {

	@Autowired
	private DayServiceProxy dayServiceProxy;
	
	@Test
	public void testGetAll() {
		dayServiceProxy.getAll();
	}

	@Test
	public void testGetById() {
		dayServiceProxy.getById(0);
	}
	
}
