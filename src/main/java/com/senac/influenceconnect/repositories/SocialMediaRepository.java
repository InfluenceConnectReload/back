package com.senac.influenceconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.SocialMedia;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMedia, Long> {

}
