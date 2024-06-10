package com.api.InfluenceConnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.InfluenceConnect.models.Influencer;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    // Se você precisar de métodos personalizados para consultar os influenciadores, você pode adicioná-los aqui
}

