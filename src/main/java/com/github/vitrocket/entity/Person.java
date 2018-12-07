package com.github.vitrocket.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;

}
