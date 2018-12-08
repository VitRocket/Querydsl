package com.github.vitrocket.dao;

import com.github.vitrocket.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonQuerydslRepository extends JpaRepository<Person, Long>, QuerydslPredicateExecutor<Person> {

}
