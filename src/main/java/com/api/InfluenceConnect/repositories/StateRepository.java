package com.api.InfluenceConnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.InfluenceConnect.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    // Se você precisar de métodos personalizados para consultar os estados, você pode adicioná-los aqui
}
