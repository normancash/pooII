package com.ni.salvadoritapizza.controller;

import com.ni.salvadoritapizza.dto.DepartmentDTO;
import com.ni.salvadoritapizza.model.Department;
import com.ni.salvadoritapizza.service.IServiceDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("*")
public class ControllerDepartamento {

    @Autowired
    private IServiceDepartment serviceDepartment;

    @GetMapping("/all")
    public List<Department> getAll() {
        return serviceDepartment.findAll();
    }

    @GetMapping("/findById/{id}")
    public Department findById(@PathVariable Long id) {
        return serviceDepartment.findById(id);
    }

    @PostMapping("/insert")
    public Department insertDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return serviceDepartment.save(departmentDTO);
    }

    @PostMapping("/update")
    public Department updateDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return serviceDepartment.save(departmentDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable Long id){
        serviceDepartment.delete(id);
    }

}
