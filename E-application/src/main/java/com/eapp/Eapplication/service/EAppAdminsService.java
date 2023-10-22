package com.eapp.Eapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	        
	        admin.setAdmin_name(updatedAdmin.getAdmin_name());
	        admin.setAdmin_email(updatedAdmin.getAdmin_email());
	        admin.setAdmin_contact(updatedAdmin.getAdmin_contact());
	        admin.setAdmin_password(updatedAdmin.getAdmin_password());

	        return repository.save(admin);
	    } else {
	        throw new DataNotFoundException("AdminEntity with ID " + id + " not found.");
	    }
	}

}
	
	