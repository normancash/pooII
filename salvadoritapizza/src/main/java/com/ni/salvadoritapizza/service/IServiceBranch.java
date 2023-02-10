package com.ni.salvadoritapizza.service;


import com.ni.salvadoritapizza.dto.BranchDTO;
import com.ni.salvadoritapizza.model.Branch;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceBranch {

    public List<Branch> listAll();

    public Branch findById(Long id);

    public void deleteById(Long id);

    public Branch save(BranchDTO branchDTO);

    public List<Branch> listBranchByDepartment(Long idDeparment, Long idMunicipio);
}
