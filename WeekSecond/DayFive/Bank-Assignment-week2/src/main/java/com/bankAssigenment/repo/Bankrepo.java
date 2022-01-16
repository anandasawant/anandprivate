package com.bankAssigenment.repo;


import com.bankAssigenment.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bankrepo extends JpaRepository<Bank,Long> {


}
