package com.senac.influenceconnect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.influenceconnect.enums.UserType;
import com.senac.influenceconnect.models.Role;
//import com.senac.influenceconnect.models.Role.UserType;
import com.senac.influenceconnect.repositories.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public boolean setDefaultRoles() {
		List<Role> roles = roleRepo.findAll();
        
        if(roles.isEmpty()) {
            createDefaultRoles();
            return true;
        }
        
        return false;
    
	}
	
	private void createDefaultRoles() {
		UserType[] roles = {
                UserType.ADM,
                UserType.INFLUENCER,
                UserType.COMPANY
        };
        
        for(int i =0; i < roles.length;++i) {
            Role newRole = new Role(roles[i]);
            roleRepo.save(newRole);
        }
    
	}
}
