package com.scorpion.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scorpion.data.dao.ActorDao;
import com.scorpion.data.dao.ActorRepo;
import com.scorpion.data.entity.Actor;

@Service
public class ActorService {

	@Autowired
	private ActorDao actorDao;

	public Collection<Actor> getAllActor() {

		Collection<Actor> actors = new ArrayList<>();
		Iterator<Actor> itr = this.actorDao.findAll().iterator();

		while (itr.hasNext()) {
			actors.add(itr.next());
		}

		return actors;
	}

}
