package com.ni.salvadoritapizza.repository;

import com.ni.salvadoritapizza.model.DetailOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailOrderRepository extends JpaRepository<DetailOrder,Long> {
}
