package com.scorpion.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scorpion.data.entity.Actor;
import com.scorpion.data.entity.Person;
import com.scorpion.service.ActorService;
import com.scorpion.service.PersonService;

@RestController
@RequestMapping(value="/students")
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private ActorService actorService;

	 @RequestMapping(value="/fake",method=RequestMethod.GET)
	public Collection<Person> getAllStudents() {
		return this.personService.getAllStudents();
	}
	
	@RequestMapping(value="/actors",method=RequestMethod.GET)
	public Collection<Actor> getAllActor() {
		return this.actorService.getAllActor();
	}
}
