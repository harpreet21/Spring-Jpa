package com.scorpion.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scorpion.data.dao.PersonDao;
import com.scorpion.data.entity.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	public Collection<Person> getAllStudents() {
		return this.personDao.getAllStudents();
	}
}
