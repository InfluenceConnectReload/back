package com.senac.influenceconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    // Se você precisar de métodos personalizados para consultar os estados, você pode adicioná-los aqui
}
