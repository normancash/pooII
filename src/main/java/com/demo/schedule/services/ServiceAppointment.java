package com.demo.schedule.services;

import com.demo.schedule.model.Appointment;
import com.demo.schedule.repository.IRepoAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceAppointment implements IServiceAppointment{

    @Autowired
    private IRepoAppointment repo;

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<Appointment> insertAppointment(Appointment appointment) {
        return Optional.of(repo.save(appointment));
    }

    @Override
    public Optional<Appointment> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public void deleteAppointment(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Optional<Appointment> updateAppointment(Appointment appointment)  {
        return Optional.of(repo.save(appointment));
    }
}
