package com.scorpion.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.scorpion.data.entity.Actor;
import com.scorpion.service.ActorService;

@RestController
@RequestMapping(value = "/a")
public class ActorController {

	@Autowired
	private ActorService ActorService;

	@JsonIgnore
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Collection<Actor> test() {
		return this.ActorService.getAllActor();
	}

}
