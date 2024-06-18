package com.senac.influenceconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.Adm;

@Repository
public interface AdmRepository extends JpaRepository<Adm, Long>{
}
