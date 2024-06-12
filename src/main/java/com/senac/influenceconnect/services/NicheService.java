package com.senac.influenceconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.models.Niche;
import com.senac.influenceconnect.repositories.NicheRepository;

@Service
public class NicheService {
	
	@Autowired
	private NicheRepository nicheRepo;
	
	public boolean setDefaultNiches() {
		List<Niche> niches = nicheRepo.findAll();
		
		if(niches.isEmpty()) {
			createDefaultNiches();
			return true;
		}
		
        return false;
    }
	private void createDefaultNiches() {
		String[] niches = {
			    "esporte",
			    "musica",
			    "moda",
			    "saude-bem-estar",
			    "negocios",
			    "design-interior",
			    "tecnologia",
			    "fotografia",
			    "culinaria",
			    "educacao",
			    "games",
			    "sustentabilidade",
			    "automoveis",
			    "viagens",
			    "pets",
			    "vida",
			    "politica-ativismo",
			    "outros"
		};
		
		for(int i =0; i < niches.length;++i) {
            Niche newNiche = new Niche(null, niches[i], null);
            nicheRepo.save(newNiche);
        }
    }
}
