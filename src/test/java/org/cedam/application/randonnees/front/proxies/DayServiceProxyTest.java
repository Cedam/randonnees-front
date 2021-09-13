package org.cedam.application.randonnees.front.proxies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.cedam.application.randonnees.front.bean.DayBean;
import org.cedam.application.randonnees.front.test.mock.Constante;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest
public class DayServiceProxyTest {

    @Autowired
    private DayServiceProxy object;


    //@Autowired
    //private RestTemplate restTemplate;

    //private MockRestServiceServer mockServer;

	/*@Before("")
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
	}*/

    private ObjectMapper mapper = new ObjectMapper();

    //@Autowired
    //private MockRestServiceServer server;

    //@Autowired
    //private ObjectMapper objectMapper;

//	@Before("")
//	public void setUp() throws Exception {
//		DayBean day = object.getById(Constante.DAY_TEST_ID_1);
//		String detailsString =
//				objectMapper.writeValueAsString(day);
//
//		this.server.expect(requestTo("/john/details"))
//				.andRespond(withSuccess(detailsString, MediaType.APPLICATION_JSON));
//	}

    @Mock
    private RestTemplate restTemplate;


    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        Mockito.when(restTemplate.getForEntity("http://localhost:8085/days/1", DayBean.class))
                .thenReturn(new ResponseEntity(Constante.getDay(), HttpStatus.OK));

        //TODO DCO 
        DayBean employee = object.getById(Constante.DAY_TEST_ID_1);
        //assertThat(Constante.getDay()).isEqualTo(employee);
    }

    //Test
    public void testGetById() throws URISyntaxException, JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

        server.expect(ExpectedCount.manyTimes(), requestTo("http://localhost:8085/days/1")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(mapper.writeValueAsString(Constante.getDay()), MediaType.APPLICATION_JSON));

        DayBean hotel = restTemplate.getForObject("http://localhost:8085/days/1", DayBean.class, 1);

        DayBean day = object.getById(Constante.DAY_TEST_ID_1);


        server.verify();

        long idDay = Constante.DAY_TEST_ID_1;
        DayBean day2 = object.getById(idDay);


        assertThat(idDay).isEqualTo(day2.getId());

        assertThrows(Exception.class, () -> object.getById(-1));
    }

}
