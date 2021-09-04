package com.demo.schedule.repository;

import com.demo.schedule.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoContact extends JpaRepository<Contact,Integer> {
}
