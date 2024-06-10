package com.api.InfluenceConnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.InfluenceConnect.models.State;
import com.api.InfluenceConnect.repositories.StateRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository stateRepo;
	
	public boolean setDefaultStates() {
		List<State> states = stateRepo.findAll();
		
		if(states.isEmpty()) {
			createDefaultStates();
			return true;
		}
		
		return false;
	}
	
	private void createDefaultStates() {
		String[] stateNames = {
			    "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
			    "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso",
			    "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná",
			    "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", 
			    "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", 
			    "São Paulo", "Sergipe", "Tocantins", "Fora do Brasil"
		};
		String[] acronyms = {
			    "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", 
			    "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", 
			    "SP", "SE", "TO", "Outro"
		};
		
		for(int i =0; i < stateNames.length;++i) {
			State newState = new State(null, stateNames[i], acronyms[i]);
			stateRepo.save(newState);
		}
	}
}
