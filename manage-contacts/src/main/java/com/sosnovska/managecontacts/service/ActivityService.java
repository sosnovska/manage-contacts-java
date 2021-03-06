package com.sosnovska.managecontacts.service;

import java.util.Optional;

import com.sosnovska.managecontacts.model.Activity;


public interface ActivityService {
	
	public Iterable<Activity> getActivities();

	public Optional<Activity> getActivityById(Long id);

	Activity createOrUpdateActivity(Activity contact);

	void deleteActivity(Long id);
}
