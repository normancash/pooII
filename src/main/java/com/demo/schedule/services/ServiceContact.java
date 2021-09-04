package com.demo.schedule.services;

import com.demo.schedule.model.Contact;
import com.demo.schedule.repository.IRepoContact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceContact implements IServiceContact{

    @Autowired
    private IRepoContact repo;

    @Override
    public Page<Contact> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Contact> insertContact(Contact contact) {
        return Optional.of(repo.save(contact));
    }

    @Override
    public Optional<Contact> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public void deleteContact(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Contact> updateContact(Contact contact) {
        return Optional.of(repo.save(contact));
    }


}
