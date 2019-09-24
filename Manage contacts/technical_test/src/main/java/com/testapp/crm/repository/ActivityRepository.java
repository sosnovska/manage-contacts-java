package com.testapp.crm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.testapp.crm.model.Activity;
@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
}