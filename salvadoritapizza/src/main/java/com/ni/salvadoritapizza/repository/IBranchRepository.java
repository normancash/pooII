package com.ni.salvadoritapizza.repository;

import com.ni.salvadoritapizza.model.Branch;
import com.ni.salvadoritapizza.model.Department;
import com.ni.salvadoritapizza.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBranchRepository extends JpaRepository<Branch,Long> {

    @Query("select e from Branch e where e.department = :department and e.municipio = :municipio")
    public List<Branch> getBranchByDepartmentAndMunicipio(Department department, Municipio municipio);
}
