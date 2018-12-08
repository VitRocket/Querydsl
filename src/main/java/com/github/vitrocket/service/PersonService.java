package com.github.vitrocket.service;

import com.github.vitrocket.entity.Person;

import java.util.List;

public interface PersonService {

	List<Person> searchByFirstName(String firstName);

}
