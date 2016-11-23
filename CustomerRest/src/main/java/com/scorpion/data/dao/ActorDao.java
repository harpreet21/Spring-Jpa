package com.scorpion.data.dao;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.scorpion.data.entity.Actor;

@Repository
public interface ActorDao extends CrudRepository<Actor, Short>{

	

}
