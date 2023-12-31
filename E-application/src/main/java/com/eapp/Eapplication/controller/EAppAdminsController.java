package com.eapp.Eapplication.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	private static final Logger logger=LoggerFactory.getLogger(EAppAdminsController.class);
	

	private final EAppAdminsService service;

	@Autowired
	public EAppAdminsController(EAppAdminsService service) {
		this.service = service;
	}
	
	/*
	 * Create a new admin record.
	 * 
	 * @param entity The admin entity to be created.
	 * @return ResponseEntity with the created admin and HTTP status 201 (Created).
	 */
	
	
	@PostMapping
	public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity entity) {	
		logger.info("Creating a new admin{}",entity);
		return new ResponseEntity<>(service.createAdmin(entity), HttpStatus.CREATED);
	}
	
	/*
	 * Retrieve all admin details.
	 * 
	 * @return ResponseEntity with a list of admin entities and HTTP status 200 (OK).
	 * @throws DataNotFoundException if no data is found.
	 */

	@GetMapping
	public ResponseEntity<List<AdminEntity>> getAllAdminData() throws DataNotFoundException {
		logger.info("Retreving all admin data.");
		List<AdminEntity> data = service.getAllAdminData();
		if (data.isEmpty()) {
			logger.warn("No data found!!!");
			throw new DataNotFoundException("No data found!!!");
		}
		
		return ResponseEntity.ok(data);
	}
	
	/*
	 * Retrieve admin details by ID.
	 * 
	 * @param id The ID of the admin entity to retrieve.
	 * @return ResponseEntity with the admin entity and HTTP status 200 (OK).
	 * @throws DataNotFoundException if the admin with the specified ID is not found.
	 */
	@GetMapping("{id}")
	public ResponseEntity<AdminEntity> getAdminById(@PathVariable Long id) throws DataNotFoundException {
		logger.info("Retreving admin details by ID{}",id);
	    Optional<AdminEntity> data = service.getAdminById(id);

	    return ResponseEntity.ok(data.get());
	   
	}
	/*
	 * Update admin details by its ID.
	 * 
	 * @param id The ID of the admin entity to be updated.
	 * @param updatedAdmin The updated admin entity.
	 * @return ResponseEntity with the updated admin and HTTP status 200 (OK).
	 * @throws DataNotFoundException if the admin with the specified ID is not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<AdminEntity> updateAdmin(@PathVariable Long id, @RequestBody AdminEntity updatedAdmin) throws DataNotFoundException {
		logger.info("Updating admin with ID{}",id);
		 AdminEntity admin = service.updateAdmin(id, updatedAdmin);
		return ResponseEntity.ok(admin);
	}
	/*
	 * Delete admin details by its ID
	 * 
	 * @param id the ID of the admin entity to delete
	 * @return ResponseEntity with the delete admin and HTTP status 204
	 * @throws DataNotFoundException if admin with the sprcified ID id not found.
	 */

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAdminById(@PathVariable Long id) throws DataNotFoundException {
		logger.info("Deleting the admin with ID{}",id);
	    if (service.deleteAdminById(id)) {
	    	logger.info("Admin deleted successfully with ID{}",id );
	        return ResponseEntity.ok("Admin deleted succesfully with Id : "+id); // 204 No Content for successful deletion
	    } else {
	    	logger.info("Admin with ID{} not found !!!",id);
	        return ResponseEntity.notFound().build();
	    }
	}
	

}
