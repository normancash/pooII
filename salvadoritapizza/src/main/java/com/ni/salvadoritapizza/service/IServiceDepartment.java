package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.dto.DepartmentDTO;
import com.ni.salvadoritapizza.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceDepartment {

    public List<Department> findAll();

    public Department findById(Long id);

    public Department save(DepartmentDTO deparmentDTO);

    public void delete(Long id);
}
