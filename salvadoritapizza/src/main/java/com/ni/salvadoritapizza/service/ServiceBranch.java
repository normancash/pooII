package com.ni.salvadoritapizza.service;

import com.ni.salvadoritapizza.dto.BranchDTO;
import com.ni.salvadoritapizza.model.Branch;
import com.ni.salvadoritapizza.repository.IBranchRepository;
import com.ni.salvadoritapizza.repository.IDepartmentRepository;
import com.ni.salvadoritapizza.repository.IMunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBranch implements IServiceBranch{

    @Autowired
    private IBranchRepository repositoryBranch;

    @Autowired
    private IMunicipioRepository repositoryMunicipio;

    @Autowired
    private IDepartmentRepository repositoryDepar;

    @Override
    public List<Branch> listAll() {
        return repositoryBranch.findAll();
    }

    @Override
    public Branch findById(Long id) {
        return repositoryBranch.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
         repositoryBranch.deleteById(id);
    }

    @Override
    public Branch save(BranchDTO branchDTO) {
        Branch branch = null;
        if (branchDTO.getId()== null){
            branch = new Branch();
        }
        else {
            branch = repositoryBranch.findById(branchDTO.getId()).get();
        }
        branch.setName(branchDTO.getName());
        branch.setDescription(branchDTO.getDescription());
        branch.setMunicipio(repositoryMunicipio.findById(branchDTO.getIdMunicipio()).get());
        branch.setDepartment(repositoryDepar.findById(branchDTO.getIdDepartment()).get());
        return repositoryBranch.save(branch);
    }

    @Override
    public List<Branch> listBranchByDepartment(Long idDeparment, Long idMunicipio) {
        return repositoryBranch.getBranchByDepartmentAndMunicipio(
               repositoryDepar.findById(idDeparment).get(),repositoryMunicipio.findById(idMunicipio).get()
        );
    }
}
