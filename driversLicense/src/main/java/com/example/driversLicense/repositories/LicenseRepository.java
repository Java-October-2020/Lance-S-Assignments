package com.example.driversLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.driversLicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>
{
	License findTopByOrderByNumberDesc();
}
