package com.demo.schedule.services;

import com.demo.schedule.model.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IServiceAppointment {

    Page<Appointment> findAll(Pageable pageable);

    Optional<Appointment> insertAppointment(Appointment appointment);

    Optional<Appointment> findById(Integer id);

    void deleteAppointment(Integer id);

    Optional<Appointment> updateAppointment(Appointment appointment);
}
