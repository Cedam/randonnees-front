package org.cedam.application.randonnees.front.bean;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TrekBeanTest {


	@Test
	public void test() {
		var id = 1;
		var name = "name";
		var year = 99;
		var location = "location";
		var days = new ArrayList<DayBean>();
		days.add(new DayBean());

		var trek = new TrekBean();
		trek.setId(id);
		trek.setName(name);
		trek.setYear(year);
		trek.setLocation(location);
		trek.setDays(days);

		assertThat(id).isEqualTo(trek.getId());
		assertThat(name).isEqualTo(trek.getName());
		assertThat(location).isEqualTo(trek.getLocation());
		assertThat(year).isEqualTo(trek.getYear());
		assertThat(location).isEqualTo(trek.getLocation());
		assertThat(days).isEqualTo(trek.getDays());
	}

}
