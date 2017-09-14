package com.duongnv.spring.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duongnv.spring.dao.entity.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long> {

}
