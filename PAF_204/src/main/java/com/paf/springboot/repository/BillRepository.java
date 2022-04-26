package com.paf.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paf.springboot.model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long>{

}
