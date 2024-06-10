package com.api.InfluenceConnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.InfluenceConnect.models.MarketingChannel;
import com.api.InfluenceConnect.repositories.MarketingChannelRepository;

@Service
public class MarketingChannelService {

	@Autowired
	private MarketingChannelRepository marketingChannelRepo;
	
	public boolean setDefaultMarketingChannels() {
	    List<MarketingChannel> marketingChannels = marketingChannelRepo.findAll();
	    
	    if (marketingChannels.isEmpty()) {
	        createDefaultMarketingChannels();
	        return true;
	    }
	    
	    return false;
	}

	private void createDefaultMarketingChannels() {
	    String[] marketingChannels = {
	        "facebook",
	        "instagram",
	        "youtube",
	        "tiktok",
	        "twitter",
	        "TV"
	    };
	    
	    for (String channel : marketingChannels) {
	        MarketingChannel newChannel = new MarketingChannel(null, channel);
	        marketingChannelRepo.save(newChannel);
	    }
	}
	
}
