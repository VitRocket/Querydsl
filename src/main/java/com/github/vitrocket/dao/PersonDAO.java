package com.github.vitrocket.dao;

import com.github.vitrocket.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDAO extends CrudRepository<Person, Long> {
	public List<Person> findByFirstName(String firstName);
}
