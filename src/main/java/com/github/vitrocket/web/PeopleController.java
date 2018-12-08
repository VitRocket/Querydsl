package com.github.vitrocket.web;

import com.github.vitrocket.dao.PersonDAO;
import com.github.vitrocket.entity.Person;
import com.github.vitrocket.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PeopleController {

	private final PersonDAO personDAO;
	private final PersonService personService;

	@GetMapping("/people")
	public Iterable<Person> searchPeople(@RequestParam(value = "search") String search) {
		List<Person> people = personDAO.findByFirstName(search);
		log.info("People: {}", people);
		return people;
	}

	@GetMapping("/people2")
	public Iterable<Person> searchPeople2(@RequestParam(value = "search") String search) {
		List<Person> people = personService.searchByFirstName(search);
		log.info("People: {}", people);
		return people;
	}
}
