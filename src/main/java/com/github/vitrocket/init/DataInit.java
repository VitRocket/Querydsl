package com.github.vitrocket.init;

import com.github.vitrocket.dao.PersonDAO;
import com.github.vitrocket.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInit implements ApplicationRunner {

	private final PersonDAO personDAO;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<Person> people = initPeople();
		log.info("Init people: {}", people);
	}

	private List<Person> initPeople() {
		List<Person> people = new ArrayList<>();
		if (personDAO.count() == 0) {
			Person person = new Person("Mikel", "Rocket");
			personDAO.save(person);
			people.add(person);

			person = new Person("Ivan", "Rocket");
			personDAO.save(person);
			people.add(person);
		}
		return people;
	}
}
