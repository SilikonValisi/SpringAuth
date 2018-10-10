package com.loginProject.withMongo.Register;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends MongoRepository<Userr,String>{
	
	Userr findByUsername(@Param("username") String username);
	
}
