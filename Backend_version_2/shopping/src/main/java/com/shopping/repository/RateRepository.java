package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.entities.Rates;

public interface RateRepository extends JpaRepository<Rates, Long> {

}