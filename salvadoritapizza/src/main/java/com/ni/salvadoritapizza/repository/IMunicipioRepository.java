package com.ni.salvadoritapizza.repository;

import com.ni.salvadoritapizza.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMunicipioRepository extends JpaRepository<Municipio,Long> {


}
