package com.senac.influenceconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.MarketingChannel;

@Repository
public interface MarketingChannelRepository extends JpaRepository<MarketingChannel, Long> {

}
