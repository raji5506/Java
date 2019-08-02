package com.kovanlabs.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workprofile")
public class WorkProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)

	private int id;

	private String designation;
	private float yearsOfExperience;
	private String jobDescription;
	private String achievements;
	private String skills;
//	private TimeDuration timeDuration;
//	private List<Reference> refDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getAchievements() {
		return achievements;
	}

	public void setAchievements(String achievements) {
		this.achievements = achievements;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

//	public TimeDuration getTimeDuration() {
//		return timeDuration;
//	}
//
//	public void setTimeDuration(TimeDuration timeDuration) {
//		this.timeDuration = timeDuration;
//	}

//	public List<Reference> getRefDetails() {
//		return refDetails;
//	}
//
//	public void setRefDetails(List<Reference> refDetails) {
//		this.refDetails = refDetails;
//	}

}
