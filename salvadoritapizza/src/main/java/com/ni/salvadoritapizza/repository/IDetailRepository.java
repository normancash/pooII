package com.ni.salvadoritapizza.repository;

import com.ni.salvadoritapizza.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailRepository extends JpaRepository<Detail,Long> {
}
