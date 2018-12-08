package com.github.vitrocket.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleControllerTest {

	@LocalServerPort
	private int port;
	private UriComponentsBuilder uriBuilder;

	@Autowired
	private TestRestTemplate template;

	@Before
	public void setUp() throws MalformedURLException {
		uriBuilder = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port(port)
				.path("/{path}")
				.queryParam("search", "Ivan");
		UriComponents uriComponents = uriBuilder.build();
		assertEquals("http://localhost:" + port + "/{path}?search=Ivan", uriComponents.toUriString());
	}

	@Test
	public void getPeople() {
		UriComponents uriComponents = uriBuilder.build().expand("people").encode();
		assertEquals("http://localhost:" + port + "/people?search=Ivan", uriComponents.toUriString());
		ResponseEntity<String> response = template.getForEntity(uriComponents.toUriString(), String.class);
		assertThat(response.getBody(), equalTo("[{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Rocket\"}]"));
	}

	@Test
	public void getPeople2() {
		UriComponents uriComponents = uriBuilder.build().expand("people2").encode();
		assertEquals("http://localhost:" + port + "/people2?search=Ivan", uriComponents.toUriString());
		ResponseEntity<String> response = template.getForEntity(uriComponents.toUriString(), String.class);
		assertThat(response.getBody(), equalTo("[{\"id\":2,\"firstName\":\"Ivan\",\"lastName\":\"Rocket\"}]"));
	}
}
