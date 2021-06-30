package org.cedam.application.randonnees.front.test.mock;

import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.bean.TrekBean;
import org.junit.jupiter.api.Disabled;

@Disabled
public class Constante {

	public static TrekBean getTrek() {
		var trek = new TrekBean();
		trek.setId(TREK_TEST_ID_1);
		trek.setName(TREK_TEST_NAME_1);
		trek.setLocation(TREK_TEST_LOCATION_1);
		return trek;
	}
	
	public static DayBean getDay() {
		var day = new DayBean();
		day.setNumber(DAY_TEST_NUMBER_1);
		day.setTrek(getTrek());
		return day;
	}

	
	public final static Long DAY_TEST_ID_1 = 1L;
	public static final Long DAY_TEST_ID_2 = 2L;
	public final static String DAY_TEST_NUMBER_1 = "TEST_NUMBER_1";

	public final static Long TREK_TEST_ID_1 = 1L;
	public final static String TREK_TEST_NAME_1 = "TEST_NAME_1";
	public final static String TREK_TEST_LOCATION_1 = "TEST_NUMBER_1";

	public final static Long TREK_TEST_ID_2 = 2L;
	public final static String TREK_TEST_NAME_2 = "TEST_NUMBER_2";
	public final static String TREK_TEST_LOCATION_2 = "TEST_NUMBER_2";

}
