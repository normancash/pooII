package com.demo.schedule.repository;

import com.demo.schedule.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepoAppointment extends JpaRepository<Appointment,Integer> {
}
