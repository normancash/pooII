package com.demo.schedule.services;

import com.demo.schedule.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public interface IServiceContact {

    Page<Contact> findAll(Pageable pageable);

    Optional<Contact> insertContact(Contact contact);

    Optional<Contact> findById(Integer id);

    void deleteContact(Integer id);

    Optional<Contact> updateContact(Contact contact);

}
