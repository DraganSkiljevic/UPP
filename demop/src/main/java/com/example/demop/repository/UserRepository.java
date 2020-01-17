package com.example.demop.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demop.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	User findOneById(long id);
	User findOneByMail(String mail);
	User findOneByUsername(String username);
	List<User> findAllByUsername(String username);


}
