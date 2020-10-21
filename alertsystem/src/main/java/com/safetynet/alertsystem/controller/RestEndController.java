package com.safetynet.alertsystem.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alertsystem.model.MedicalRecords;
import com.safetynet.alertsystem.model.PersonalInformation;
import com.safetynet.alertsystem.service.RestService;

@RestController
public class RestEndController {
	
	private static final Logger logger = LogManager.getLogger("AlertController");
	
	private RestService restService;
	
	@Autowired
	public RestEndController(RestService restService) {
		super();
		this.restService = restService;
	}
	
	@PostMapping("/medicalRecord")
	public ResponseEntity<String> postMedicalRecord(@RequestBody MedicalRecords mediRecord) {
		logger.info("HTTP POST request recieved at /POST/medicalRecord URL");		
		
		JSONObject postMedicalRecord = new JSONObject(restService.saveMedicalRecord(mediRecord));
		
		return new ResponseEntity<String>(postMedicalRecord.toString(), HttpStatus.CREATED);
	}
	 
	@PutMapping("/medicalRecord")
	public ResponseEntity<String> putMedicalRecord(@RequestBody MedicalRecords mediRecord) {
		logger.info("HTTP PUT request recieved at /PUT/medicalRecord URL");
		
		JSONObject putMedicalRecord = new JSONObject(restService.putMedicalRecord(mediRecord));
		
		return new ResponseEntity<String>(putMedicalRecord.toString(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/medicalRecord")
	public ResponseEntity<String> deleteMedicalRecord(@RequestParam String firstName, String lastName) {
		
		logger.info("HTTP PUT request recieved at /DELETE/medicalRecord URL");
		
		JSONObject deleteMedicalRecord = new JSONObject(restService.deleteMedicalRecord(firstName, lastName));
		
		return new ResponseEntity<String>(deleteMedicalRecord.toString(), HttpStatus.OK);
	}
	
	@PostMapping("/person")
	public ResponseEntity<String> postPerson(@RequestBody PersonalInformation person) {
		logger.info("HTTP POST request recieved at /POST/person URL");		
		
		JSONObject postPerson = new JSONObject(restService.savePerson(person));
		
		return new ResponseEntity<String>(postPerson.toString(), HttpStatus.CREATED);
	}
	
	@PutMapping("/person")
	public ResponseEntity<String> putPersonalInformation(@RequestBody PersonalInformation person) {
		logger.info("HTTP PUT request recieved at /PUT/person URL");
		
		JSONObject putPerson = new JSONObject(restService.putPersonalInformation(person));
		
		return new ResponseEntity<String>(putPerson.toString(), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/person")
	public ResponseEntity<String> deletePerson(@RequestParam String firstName, String lastName) {
		
		logger.info("HTTP PUT request recieved at /DELETE/person URL");
		
		JSONObject deletePerson = new JSONObject(restService.deletePerson(firstName, lastName));
		
		return new ResponseEntity<String>(deletePerson.toString(), HttpStatus.OK);
	}
}
