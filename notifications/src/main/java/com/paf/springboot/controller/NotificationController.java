package com.paf.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.springboot.exception.ResourceNotFoundException;
import com.paf.springboot.model.Notification;
import com.paf.springboot.repository.NotificationRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class NotificationController {

	@Autowired
	private NotificationRepository notificationRepository;
	
	// get all notifications
	@GetMapping("/notifications")
	public List<Notification> getAllNotifications(){
		return notificationRepository.findAll();
	}		
	
	// create notification rest api
	@PostMapping("/notifications")
	public Notification createNotification(@RequestBody Notification notification) {
		return notificationRepository.save(notification);
	}
	
	// get notification by id rest api
	@GetMapping("/notifications/{id}")
	public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
		Notification notification = notificationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not exist with id :" + id));
		return ResponseEntity.ok(notification);
	}
	
	// update notification rest api
	
	@PutMapping("/notifications/{id}")
	public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notificationDetails){
		Notification notification = notificationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not exist with id :" + id));
		
		notification.setHeader(notificationDetails.getHeader());
		notification.setDescription(notificationDetails.getDescription());
		
		Notification updatedNotification = notificationRepository.save(notification);
		return ResponseEntity.ok(updatedNotification);
	}
	
	// delete notification rest api
	@DeleteMapping("/notifications/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteNotification(@PathVariable Long id){
		Notification notification = notificationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Notification not exist with id :" + id));
		
		notificationRepository.delete(notification);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
