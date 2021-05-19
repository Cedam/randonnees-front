package org.cedam.application.randonnees.front.proxies;
import org.cedam.application.randonnees.front.bean.TrekBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrekServiceProxyTest {
	
	@Autowired
	private TrekServiceProxy trekServiceProxy;
	
	@Test
	public void testGetAll() {
		trekServiceProxy.getAll();
	}
	
	@Test
	public void testGetById() {
		trekServiceProxy.getById(0);
	}
	
	@Test
	public void testSave() {
		trekServiceProxy.save(new TrekBean());
	}

}
