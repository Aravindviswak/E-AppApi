package com.eapp.Eapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapp.Eapplication.entity.AdminEntity;
import com.eapp.Eapplication.exception.DataNotFoundException;
import com.eapp.Eapplication.service.EAppAdminsService;

@RestController
@RequestMapping("/api/admin")
public class EAppAdminsController {

	private final EAppAdminsService service;

	@Autowired
	public EAppAdminsController(EAppAdminsService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity entity) {
		return new ResponseEntity<>(service.createAdmin(entity), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<AdminEntity>> getAllAdminData() throws DataNotFoundException {
		List<AdminEntity> data = service.getAllAdminData();
		if (data.isEmpty()) {
			throw new DataNotFoundException("No data found!!!");
		}
		return ResponseEntity.ok(data);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<AdminEntity> getAdminById(@PathVariable Long id) throws DataNotFoundException {
	    Optional<AdminEntity> data = service.getAdminById(id);

	    return ResponseEntity.ok(data.get());
	   
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable Long id, @RequestBody AdminEntity updatedAdmin) {
	    try {
	        AdminEntity admin = service.updateAdmin(id, updatedAdmin);
	        if (admin != null) {
	            return ResponseEntity.ok(admin); // 200 OK with updated data
	        } else {
	            return ResponseEntity.notFound().build();// 404 Not Found if data doesn't exist
	        }
	    } catch (DataNotFoundException e) {
	        return ResponseEntity.notFound().build(); // Handle the exception with 404 Not Found
	    }
	}


}
