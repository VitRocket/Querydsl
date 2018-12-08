package com.github.vitrocket.service;

import com.github.vitrocket.dao.PersonQuerydslRepository;
import com.github.vitrocket.entity.Person;
import com.github.vitrocket.entity.QPerson;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonQuerydslRepository personQuerydslRepository;

	@Override
	public List<Person> searchByFirstName(String firstName) {
		List<Person> ret = new ArrayList<>();
		QPerson contEquation = QPerson.person;
		Predicate cnt = contEquation.firstName.contains(firstName);
		Iterable<Person> people = personQuerydslRepository.findAll(cnt);
		for (Person person : people) {
			ret.add(person);
		}
		return ret;
	}
}
