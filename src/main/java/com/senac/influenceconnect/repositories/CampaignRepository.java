package com.senac.influenceconnect.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.Campaign;
import com.senac.influenceconnect.models.Company;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long> {
	Page<Campaign> findAll(Pageable pageable);
	
	@Query(value="delete from tb_campaigns_influencers ci where ci.influencer_id = :idInfluencer", nativeQuery = true)
	void deleteInfluencerFromCampaigns(long idInfluencer);
}
