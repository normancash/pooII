package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.dto.ClientDTO;
import com.ni.salvadoritapizza.model.Client;
import com.ni.salvadoritapizza.repository.IClientRepository;
import com.ni.salvadoritapizza.repository.IDepartmentRepository;
import com.ni.salvadoritapizza.repository.IMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClient implements IServiceClient{

    @Autowired
    private IClientRepository clientRepository;

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private IMunicipioRepository municipioRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
            clientRepository.deleteById(id);
    }

    @Override
    public Client save(ClientDTO clientDTO) {
        Client client = null;
        if (clientDTO.getId() == null) {
            client = new Client();
        }
        else {
            client = clientRepository.findById(clientDTO.getId()).get();
        }
        client.setName(clientDTO.getName());
        client.setTelephone(clientDTO.getTelephone());
        client.setLastName(clientDTO.getLastName());
        client.setCedula(clientDTO.getCedula());
        client.setBillAddress1(clientDTO.getBillAddress1());
        client.setBillAddress2(clientDTO.getBillAddress2());
        client.setDepartment(departmentRepository.findById(clientDTO.getIdDepartment()).get());
        client.setMunicipio(municipioRepository.findById(clientDTO.getIdMunicipio()).get());
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).get();
    }
}
