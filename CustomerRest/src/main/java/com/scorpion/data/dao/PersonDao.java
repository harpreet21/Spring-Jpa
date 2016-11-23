package com.scorpion.data.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.scorpion.data.entity.Person;

@Repository
public class PersonDao {

	public static Map<Integer, Person> students;

	static {
		students = new HashMap<Integer, Person>() {
			{
				put(1, new Person(1, "sahil", "com"));
				put(2, new Person(1, "hema", "com"));
			}
		};
	}
	
	public Collection<Person> getAllStudents(){
		
		return this.students.values();
	}

}
