package com.senac.influenceconnect.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
