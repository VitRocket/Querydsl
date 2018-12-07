package com.github.vitrocket.web;

import com.github.vitrocket.dao.PersonDAO;
import com.github.vitrocket.entity.Person;
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

	@GetMapping("/people")
	public Iterable<Person> searchPeople(@RequestParam(value = "search") String search) {
		List<Person> people = personDAO.findByFirstName(search);
		log.info("Peple: {}", people);
		return people;
	}
}
