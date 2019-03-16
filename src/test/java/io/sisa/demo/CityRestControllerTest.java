package io.sisa.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sisa.demo.api.v1.dto.CityDTO;
import io.sisa.demo.api.v1.response.RestResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@RunWith(SpringRunner.class)
@Category(IntegrationTest.class)
public class CityRestControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void getCityById() throws Exception {

		MvcResult mvcResult =  mockMvc.perform(
				get("/v1/cities/1"))
				.andDo(print())
				.andReturn();

		assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());
        RestResponse<CityDTO> result = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), new TypeReference<RestResponse<CityDTO>>() {
        });
        assertThat(result.getContent().getCityName()).isEqualTo("Rize");

	}

    @Test
	public void addCity() throws Exception {

		CityDTO city = new CityDTO();
		city.setCityCode(33);
		city.setCityName("Mersin");
		city.setCountry("tr");

		MvcResult mvcResult =  mockMvc.perform(
						post("/v1/cities/")
						.content(objectMapper.writeValueAsString(city))
						.contentType(MediaType.APPLICATION_JSON)
				)
				.andReturn();

		assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.CREATED.value());

        Long result = objectMapper.readValue(mvcResult.getResponse().getContentAsByteArray(), Long.class);
        assertThat(result).isNotNull();

	}

    @Test
	public void deleteCityById() throws Exception {

		MvcResult mvcResult =  mockMvc.perform(
				delete("/v1/cities/1"))
				.andDo(print())
				.andReturn();

		assertThat(mvcResult.getResponse().getStatus()).isEqualTo(HttpStatus.OK.value());

	}

    @Test
	public void mockTest() {

		RestTemplate restTemplate = new RestTemplate();
		MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

		server.expect(manyTimes(), requestTo("/api/v1/cities/53")).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess("Rize", MediaType.APPLICATION_JSON));

		String result= restTemplate.getForObject("/api/v1/cities/{id}", String.class, Long.parseLong("53"));
		server.verify();
		assertThat(result).isNotNull();
		assertThat(result).isEqualTo("Rize");


	}
}
