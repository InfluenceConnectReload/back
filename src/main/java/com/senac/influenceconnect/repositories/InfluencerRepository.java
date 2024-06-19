package com.senac.influenceconnect.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.senac.influenceconnect.models.Influencer;

@Repository
public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
	Page<Influencer> findAll(Pageable pageable);
	
	@Query(value="select * from tb_influencers ti where ti.status = 'ACTIVE'", nativeQuery = true)
	List<Influencer> findAllActives();
}

