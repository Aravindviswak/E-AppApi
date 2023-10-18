package com.eapp.Eapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eapp.Eapplication.dao.EAppAdminsDAO;
import com.eapp.Eapplication.entity.AdminEntity;

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

}
