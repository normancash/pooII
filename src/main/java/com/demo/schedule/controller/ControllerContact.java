package com.demo.schedule.controller;

import com.demo.schedule.model.Contact;
import com.demo.schedule.services.IServiceContact;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/contact")
public class ControllerContact {

    @Autowired
    private IServiceContact service;

    @GetMapping("/list")
    @ResponseBody
    @ApiOperation(value="Get All the List of Contact",notes="The method only recieved the request and return a Contact List"
    )
    public ResponseEntity<?> getListContact(Pageable pageable){
        Page<Contact> contacts = service.findAll(pageable);
		if (contacts.isEmpty())
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ApiOperation(value="Get a Contact by Id",notes="The method recieved the Id of contact ",response=Contact.class
    )
    public ResponseEntity<?> getByIdContact(@PathVariable Integer id){
        Optional<Contact> contact = service.findById(id);
        if (!contact.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact.get());
    }

    @PutMapping
    @ResponseBody
    @ApiOperation(value="Update a Contact ",notes="The method recieved a Contact in JSON Format and convert and save the contact "
            ,response=Contact.class)
    public ResponseEntity<?> updateContact(@RequestBody Contact contact) {
        Optional<Contact> contactResponse = service.updateContact(contact);
        if (!contactResponse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactResponse.get());
    }

    @PostMapping
    @ResponseBody
    @ApiOperation(value="Save a Contact ",notes="The method recieved a Contact in JSON Format and convert and save the contact "
            ,response=Contact.class)
    public ResponseEntity<?> insertContact(@RequestBody Contact contact) {
        Optional<Contact> contactResponse = service.insertContact(contact);
        if (!contactResponse.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contactResponse.get());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation(value="Delete a Contact ",notes="The method delete a Contact"
            )
    public void deleteContact( @ApiParam(required = true, name = "id", value = "Id of Contact")
        @PathVariable Integer id){
        service.deleteContact(id);
    }


}
