package com.ni.salvadoritapizza.controller;


import com.ni.salvadoritapizza.dto.BranchDTO;
import com.ni.salvadoritapizza.model.Branch;
import com.ni.salvadoritapizza.service.IServiceBranch;
import com.ni.salvadoritapizza.service.IServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
@CrossOrigin("*")
public class ControllerBranch {

    @Autowired
    private IServiceBranch serviceBranch;

    @GetMapping("/all")
    public List<Branch> getAll() {
        return serviceBranch.listAll();
    }

    @GetMapping("/findById/{id}")
    public Branch findById(@PathVariable Long id) {
        return serviceBranch.findById(id);
    }

    @PostMapping("/insert")
    public Branch insertBranch(@RequestBody BranchDTO branchDTO) {
        return serviceBranch.save(branchDTO);
    }

    @PostMapping("/update")
    public Branch updateBranch(@RequestBody BranchDTO branchDTO) {
        return serviceBranch.save(branchDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBranch(@PathVariable Long id){
        serviceBranch.deleteById(id);
    }

}
