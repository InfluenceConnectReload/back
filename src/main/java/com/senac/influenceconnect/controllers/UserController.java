package com.senac.influenceconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.influenceconnect.dto.LoginRequestDTO;
import com.senac.influenceconnect.dto.LoginResponseDTO;
import com.senac.influenceconnect.models.User;
import com.senac.influenceconnect.requests.EmailAvailabilityRequest;
import com.senac.influenceconnect.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {

	@Autowired
	private UserService userServ;	
	
	@PostMapping(value = "/is-email-available")
    public ResponseEntity<EmailAvailabilityResponse> isEmailAvailable(@RequestBody EmailAvailabilityRequest req){
		boolean isAvailable = userServ.isEmailAvailable(req.getEmail());
		EmailAvailabilityResponse response = new EmailAvailabilityResponse();
		response.email = req.getEmail();
		response.isAvailable = isAvailable;
		response.setMessage((isAvailable?"O email está disponível":"Email está sendo usado"));
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO logDTO) {
		User u= userServ.login(logDTO.getEmail(), logDTO.getPassword());
		LoginResponseDTO res = new LoginResponseDTO();
		
		if(u!=null) {
			res.setUser(u);
			res.setMessage("Login realizado com sucesso!");
			res.setSucess("true");
			res.setToken("token super seguro");
            return ResponseEntity.status(HttpStatus.OK).body(res);
        }
		
		res.setUser(u);
		res.setSucess("false");
		res.setMessage("Usuário ou senha inválidos!");
		res.setToken("");
		
		return ResponseEntity.status(HttpStatus.OK).body(res);
    }
	
	private class EmailAvailabilityResponse{
		public String email;
		public boolean isAvailable;
		private String message;
		
        public String getEmail() {
            return email;
        }
        
        public void setEmail(String email) {
            this.email = email;
        }
        
        public boolean isAvailable() {
            return isAvailable;
        }
        
        public void setAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
			
	}
	
}
