package com.github.vitrocket.service;

import com.github.vitrocket.dao.PersonDAO;
import com.github.vitrocket.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;


@Slf4j
@RunWith(SpringRunner.class)
@ComponentScan(basePackages = "com.github.vitrocket")
@DataJpaTest
public class PersonServiceImplTest {

	@Autowired
	private PersonServiceImpl personService;
	@Autowired
	private PersonDAO personDAO;

	private Person person;

	@Before
	public void setUp() {
		person = new Person("Hello", "Person");
		personDAO.save(person);
		assertNotNull("Can't save Person for test.", person.getId());
		log.info("{}", person);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void searchByName() {
		List<Person> people = personService.searchByFirstName(person.getFirstName());
		log.info("People: {}", people);
		assertTrue("Can't contains expected Person", people.contains(person));
	}
}
