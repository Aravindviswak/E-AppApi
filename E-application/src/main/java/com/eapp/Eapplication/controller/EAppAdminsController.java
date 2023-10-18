package com.eapp.Eapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
}
