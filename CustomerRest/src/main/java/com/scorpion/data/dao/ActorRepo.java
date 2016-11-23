package com.scorpion.data.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.scorpion.data.entity.Actor;

/*
 *  Default Repository implementing CrudRepository 
 *  Spring expose all operation defined in this repository as Restful using spring-data-rest
 *  Expose entities as /entity(s)
 */
public interface ActorRepo extends CrudRepository<Actor, Short>{

	List<Actor> findByLastName(@Param("name") String name);
}
