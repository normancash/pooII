package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.dto.ClientDTO;
import com.ni.salvadoritapizza.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceClient {

    public List<Client> getAll();

    public void deleteById(Long id);

    public Client save(ClientDTO clientDTO);

    public Client findById(Long id);
}
