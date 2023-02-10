package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.dto.DepartmentDTO;
import com.ni.salvadoritapizza.dto.MunicipioDTO;
import com.ni.salvadoritapizza.model.Department;
import com.ni.salvadoritapizza.model.Municipio;
import com.ni.salvadoritapizza.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDepartment implements IServiceDepartment{

    @Autowired
    private IDepartmentRepository repositoryDepartment;

    @Override
    public List<Department> findAll() {
        return repositoryDepartment.findAll();
    }

    @Override
    public Department findById(Long id) {
        return repositoryDepartment.findById(id).get();
    }

    @Override
    public Department save(DepartmentDTO deparmentDTO) {
        Department dep = null;
        if (deparmentDTO.getId() == null) {
            dep = new Department();
        } else {
            dep = repositoryDepartment.findById(deparmentDTO.getId()).get();
        }
        dep.setName(deparmentDTO.getName());
        dep.setDescription(deparmentDTO.getDescription());
        List<MunicipioDTO> municipios = deparmentDTO.getMunicipios();
        for (MunicipioDTO m : municipios) {
             Municipio municipio = new Municipio();
             municipio.setDescription(m.getDescription());
             municipio.setName(m.getName());
             municipio.setDepartment(dep);
             dep.getMunicipios().add(municipio);
        }
        return repositoryDepartment.save(dep);
    }

    @Override
    public void delete(Long id) {
         repositoryDepartment.deleteById(id);
    }
}
