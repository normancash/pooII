package com.ni.salvadoritapizza.controller;

import com.ni.salvadoritapizza.dto.ClientDTO;
import com.ni.salvadoritapizza.model.Client;
import com.ni.salvadoritapizza.service.IServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@CrossOrigin("*")
public class ControllerClient {

    @Autowired
    private IServiceClient serviceClient;


    @GetMapping("/all")
    public List<Client> getAll() {
        return serviceClient.getAll();
    }

    @GetMapping("/findById/{id}")
    public Client findById(@PathVariable Long id) {
        return serviceClient.findById(id);
    }

    @PostMapping("/insert")
    public Client insertClient(@RequestBody ClientDTO clientDTO) {
        return serviceClient.save(clientDTO);
    }

    @PostMapping("/update")
    public Client updateClient(@RequestBody ClientDTO clientDTO) {
        return serviceClient.save(clientDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable Long id){
        serviceClient.deleteById(id);
    }

}
