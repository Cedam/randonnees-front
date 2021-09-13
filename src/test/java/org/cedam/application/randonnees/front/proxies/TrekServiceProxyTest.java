package org.cedam.application.randonnees.front.proxies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.cedam.application.randonnees.front.bean.TrekBean;
import org.cedam.application.randonnees.front.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrekServiceProxyTest {

	@Autowired
	private TrekServiceProxy object;

	@Test
	public void testGetAll() {
		assertThat(object.getAll()).isNotNull();
	}

	@Test
	public void testGetById() {
		long idTrek = Constante.TREK_TEST_ID_1;
		TrekBean trek = object.getById(idTrek);
		assertThat(idTrek).isEqualTo(trek.getId());
	}

	@Test
	public void testSave() {
		TrekBean trekInDto = new TrekBean();
		trekInDto.setLocation(Constante.TREK_TEST_LOCATION_1);
		trekInDto.setName(Constante.TREK_TEST_NAME_1);

		// Test insert
		TrekBean trekOutDto = object.save(trekInDto);
		assertThat(trekOutDto).isNotNull();

		// Test update
		trekInDto.setId(Constante.TREK_TEST_ID_1);
		trekOutDto = object.save(trekInDto);
		assertThat(Constante.TREK_TEST_ID_1).isEqualTo(trekOutDto.getId());

		assertThrows(Exception.class, () -> object.save(null));
	}

}
