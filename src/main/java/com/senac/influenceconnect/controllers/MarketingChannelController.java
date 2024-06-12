package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.services.MarketingChannelService;

@RestController
@RequestMapping(value = "/marketingchannels")
public class MarketingChannelController {
	@Autowired
    private MarketingChannelService marketingChannelServ;

	@GetMapping(value="/setDefault")
	public boolean setDefaultMarketingChannels() {
        return marketingChannelServ.setDefaultMarketingChannels();
    }
}
