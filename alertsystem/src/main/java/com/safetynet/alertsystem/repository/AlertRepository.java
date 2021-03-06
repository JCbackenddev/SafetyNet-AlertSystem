package com.safetynet.alertsystem.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.safetynet.alertsystem.dao.ModelDAO;
import com.safetynet.alertsystem.model.PersonalInformation;

@Repository
public class AlertRepository {
	
	private List<PersonalInformation> people = new ArrayList<PersonalInformation>();
	private ModelDAO modelDAO = new ModelDAO();
	
	public List<PersonalInformation> getPeopleList() {
		return modelDAO.getPeopleFromJson();
	}
	
	public void addPerson(PersonalInformation personalInfo) {
		personalInfo.setId(modelDAO.getFireStationFromJson().size() + 1);
		modelDAO.addPersonToList(personalInfo);
	}
	
	public Integer getListSize() {
		return modelDAO.getPeopleFromJson().size();
	}
	
	public PersonalInformation findExistingPerson(Integer index) {
		for(PersonalInformation person: modelDAO.getPeopleFromJson()) {
			if(person.getId().equals(index)) {
				return person;
			}
		}
		return null;
	}
	
	public ArrayList<PersonalInformation> addDataFromJson() {
		
		if (modelDAO.getPeopleFromJson().size() < 1 ) {
			people = ModelDAO.fetchPersonalInformationFromJson();
		}
		
		return modelDAO.getPeopleFromJson();
	}

}
