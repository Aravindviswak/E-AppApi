package com.eapp.Eapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eapp.Eapplication.entity.AdminEntity;

@Repository
public interface EAppAdminsDAO extends JpaRepository<AdminEntity, Long>{

}
