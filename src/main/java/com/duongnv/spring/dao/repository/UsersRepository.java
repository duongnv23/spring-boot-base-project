package com.duongnv.spring.dao.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.duongnv.spring.dao.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	@EntityGraph(attributePaths = { "authoritieses", "groupses", "groupses.authoritieses" }, type = EntityGraphType.FETCH)
	@Query("select u from Users u where u.username=:username and u.enabled=true")
	Users findActiveUser(@Param("username") String username);
}
