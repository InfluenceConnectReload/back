package com.api.InfluenceConnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.InfluenceConnect.models.MarketingChannel;

@Repository
public interface MarketingChannelRepository extends JpaRepository<MarketingChannel, Long> {

}
