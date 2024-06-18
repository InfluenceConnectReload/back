package com.senac.influenceconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}
