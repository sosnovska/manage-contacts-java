package com.sosnovska.managecontacts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sosnovska.managecontacts.model.Activity;
import com.sosnovska.managecontacts.service.ActivityService;

@RequestMapping("/api/activities")
@RestController
public class ActivityController {
	@Autowired
	ActivityService ActivityService;

	@GetMapping("/")
	public ResponseEntity<List<Activity>> getActivities() {
		List<Activity> activities = (List<Activity>) ActivityService.getActivities();
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Activity> getActivityById(@PathVariable Long id) {
		Activity activity = ActivityService.getActivityById(id).get();
		return new ResponseEntity<Activity>(activity, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
		Activity result = ActivityService.createOrUpdateActivity(activity);
		return new ResponseEntity<Activity>(result, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteActivity(@PathVariable Long id) {
		ActivityService.deleteActivity(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity) {
		Activity result = ActivityService.createOrUpdateActivity(activity);
		return new ResponseEntity<Activity>(result, HttpStatus.OK);
	}

}
