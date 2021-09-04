package com.demo.schedule.controller;

import com.demo.schedule.model.Appointment;
import com.demo.schedule.model.Contact;
import com.demo.schedule.services.IServiceAppointment;
import com.demo.schedule.services.IServiceContact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value="/appointment")
public class ControllerAppointment {

    @Autowired
    private IServiceAppointment service;

    @GetMapping("/list")
    @ResponseBody
    @ApiOperation(value="Get All the List of appointment",notes="The method only recieved the request and return a appointment List"
    )
    public ResponseEntity<?> getListAppointment(Pageable pageable){
        Page<Appointment> appointments = service.findAll(pageable);
		if (appointments.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value="Get a Appointment by Id",notes="The method recieved the Id of appointment ",response=Appointment.class
    )
    public ResponseEntity<?> getByIdAppointment(@PathVariable Integer id){
        Optional<Appointment> appointment = service.findById(id);
        if (!appointment.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointment.get());
    }

    @PostMapping("/save")
    @ResponseBody
    @ApiOperation(value="Save a appointment ",notes="The method recieved a Appointment in JSON Format and convert and save the Appointment "
            ,response=Contact.class)
    public ResponseEntity<?> saveAppointment(@RequestBody Appointment appointment) {
        Optional<Appointment> appointmentResponse = service.insertAppointment(appointment);
        if (!appointmentResponse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointmentResponse.get());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation(value="Delete a Appointment ",notes="The method delete a Appointment"
    )
    public void deleteAppointment( @ApiParam(required = true, name = "id", value = "Id of Appointment")
                               @PathVariable Integer id){
        service.deleteAppointment(id);
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<?> updateAppointment(@RequestBody Appointment appointment) {
        Optional<Appointment> appointmentResponse = service.updateAppointment(appointment);
        if (!appointmentResponse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(appointmentResponse.get());
    }


}
