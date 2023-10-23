package com.eapp.Eapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.eapp.Eapplication.dao.EAppAdminsDAO;
import com.eapp.Eapplication.entity.AdminEntity;
import com.eapp.Eapplication.exception.DataNotFoundException;

@Service
public class EAppAdminsService {
	@Autowired
	private EAppAdminsDAO repository;

	public AdminEntity createAdmin(AdminEntity entity) {
		
		return repository.save(entity);
	}

	public List<AdminEntity> getAllAdminData() {	
		return repository.findAll();
	}

	public Optional<AdminEntity> getAdminById(Long id) throws DataNotFoundException {
	    Optional<AdminEntity> data= repository.findById(id);
	    
	    if (data.isPresent()) {
	        return data; // Extract the AdminEntity from the Optional
	    } else {
	        throw new DataNotFoundException("No admin details are there with id " + id);
	    }
	}

	public AdminEntity updateAdmin(Long id, AdminEntity updatedAdmin) throws DataNotFoundException {
	   Optional<AdminEntity> optionalData = getAdminById(id);

	    if (optionalData.isPresent()) {
	        AdminEntity admin = optionalData.get();

	        // Update the fields you want to modify
	        if(updatedAdmin.getAdmin_name()!=null) {
	        admin.setAdmin_name(updatedAdmin.getAdmin_name());
	        }
	        if(updatedAdmin.getAdmin_email()!=null) {
	        admin.setAdmin_email(updatedAdmin.getAdmin_email());
	        }
	        if(updatedAdmin.getAdmin_contact()!=null) {
	        admin.setAdmin_contact(updatedAdmin.getAdmin_contact());
	        }
	        if(updatedAdmin.getAdmin_password()!=null) {
	        admin.setAdmin_password(updatedAdmin.getAdmin_password());
	        }

	        return repository.save(admin);
	    } else {
	        throw new DataNotFoundException("AdminEntity with ID " + id + " not found.");
	    }
	}

	public boolean deleteAdminById(Long id) throws DataNotFoundException {
	    if (repository.existsById(id)) {
	        repository.deleteById(id);
	        return true;
	    }
	    else {
	    	 throw new  DataNotFoundException("The Amind is not existed with ID : "+id);
	    }


	}
}
	
	