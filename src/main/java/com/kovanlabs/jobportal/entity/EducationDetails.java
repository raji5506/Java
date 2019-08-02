package com.kovanlabs.jobportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class EducationDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)

	private int id;

	private String nameOfCource; // SSLC,HSC,BSc,BE, MCA, MBA
	private String typeOfCource; // HSC,SSLC,UG, PG
	private String board; // state board, CBSC , DIRECT , DISTSTANCE
	private String instutionName;
	private int percentageOfMarks;
//	private TimeDuration timeDuration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfCource() {
		return nameOfCource;
	}

	public void setNameOfCource(String nameOfCource) {
		this.nameOfCource = nameOfCource;
	}

	public String getTypeOfCource() {
		return typeOfCource;
	}

	public void setTypeOfCource(String typeOfCource) {
		this.typeOfCource = typeOfCource;
	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public String getInstutionName() {
		return instutionName;
	}

	public void setInstutionName(String instutionName) {
		this.instutionName = instutionName;
	}

	public int getPercentageOfMarks() {
		return percentageOfMarks;
	}

	public void setPercentageOfMarks(int percentageOfMarks) {
		this.percentageOfMarks = percentageOfMarks;
	}

//	public TimeDuration getTimeDuration() {
//		return timeDuration;
//	}
//
//	public void setTimeDuration(TimeDuration timeDuration) {
//		this.timeDuration = timeDuration;
//	}

}
