package com.timelineplanner.TimeLineMapper.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.timelineplanner.TimeLineMapper.model.ExceptionResponse;
import com.timelineplanner.TimeLineMapper.model.TimeLine;
import com.timelineplanner.TimeLineMapper.model.User;
import com.timelineplanner.TimeLineMapper.service.TimeLineServiceInterface;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RestAPIController {
	
	@Autowired
	private TimeLineServiceInterface service;
	
	
	
	//Below are TimeLine APIs
	
	@GetMapping("/timeline/user/{id}")
	public List<TimeLine> getAllTimeLineByUser(@PathVariable String id) {
        List<TimeLine> timeline = service.userById(id);
//        System.out.println(timeline);
        return timeline;
    }
	@GetMapping("/timeline")
	public List<TimeLine> getAllTimeLine() {
		List<TimeLine> timeline = service.findAll();
//        System.out.println(timeline);
		return timeline;
	}
	
	@PostMapping("/timeline")	
    public ResponseEntity<TimeLine> addTimeLine(@RequestBody TimeLine timeline) {
		System.out.println(timeline);
//		service.save(timeline.getUser());
		TimeLine savedtimeline = service.save(timeline);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedtimeline);
    }
	
	@GetMapping("/timeline/{id}")
    public ResponseEntity<Object> getTimeLineById(@PathVariable int id) {
    	Optional<TimeLine> timelineOptional = service.findById(id);
        if (timelineOptional.isPresent()) {
            return ResponseEntity.ok(timelineOptional.get());
        } else {
            ExceptionResponse errorResponse = new ExceptionResponse
            		("Timeline not found", "TimeLine with ID " + id + " not found",new Date());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
	
	@PutMapping("/timeline/{id}")
    public ResponseEntity<TimeLine> updateTimeLine(@PathVariable int id, @RequestBody TimeLine timeline) {
		timeline.setId(id);
    	TimeLine updatedtimeline = service.save(timeline);
        return ResponseEntity.ok(updatedtimeline);
    }
	
	@DeleteMapping("/timeline/{id}")
    public ResponseEntity<Void> deleteTimeLine(@PathVariable int id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
	
	
	
	//Below are User APIs
	

	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> user = service.findAllUsers();
		return ResponseEntity.ok(user);
	}

	@PostMapping("/user")	
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User saveduser = service.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveduser);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable String id) {
		Optional<User> userOptional = service.findUserById(id);
		if (userOptional.isPresent()) {
			return ResponseEntity.ok(userOptional.get());
		} else {
			ExceptionResponse errorResponse = new ExceptionResponse
					("User not found", "User with ID " + id + " not found",new Date());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
		user.setId(id);
		User updatedUser = service.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
	
}
