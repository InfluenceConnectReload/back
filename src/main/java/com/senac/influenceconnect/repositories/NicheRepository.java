package com.senac.influenceconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.Niche;

@Repository
public interface NicheRepository extends JpaRepository<Niche, Long> {
    // Se você precisar de métodos personalizados para consultar os nichos, você pode adicioná-los aqui
}

