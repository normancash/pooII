package com.ni.salvadoritapizza.repository;

import com.ni.salvadoritapizza.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client,Long> {
}
