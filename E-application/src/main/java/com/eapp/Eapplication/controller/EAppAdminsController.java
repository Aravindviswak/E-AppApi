package com.eapp.Eapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eapp.Eapplication.entity.AdminEntity;
import com.eapp.Eapplication.service.EAppAdminsService;

@RestController
@RequestMapping("/api/admin")
public class EAppAdminsController {
	@Autowired
	private EAppAdminsService service;
	
	@PostMapping
	public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity entity){
		return new ResponseEntity<AdminEntity>(service.createAdmin(entity),HttpStatus.CREATED);
	}

}
