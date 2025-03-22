package com.jobsearch.model;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "education")
public class Education {
	
//	education_id, user_id, degree, institution, field_of_study, start_year, end_year, grade
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="education_id")
	private int educationId;
	
	@Column(name="degree")
	private String degree;
	@Column(name="institution")
	private String institution;
	
	@Column(name = "field_of_study")
	private String fieldOfStudy;
	@Column(name = "start_year")
	private int startYear;
	
	@Column(name="end_year")
	private int endYear;
	
	@Column(name="grade")
	private String grade;
	
	
	
	
	
	
	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false) // Foreign key reference
	    private Users user;
	


	public int getEducationId() {
		return educationId;
	}


	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}


	public String getDegree() {
		return degree;
	}


	public void setDegree(String degree) {
		this.degree = degree;
	}


	public String getInstitution() {
		return institution;
	}


	public void setInstitution(String institution) {
		this.institution = institution;
	}


	public String getFieldOfStudy() {
		return fieldOfStudy;
	}


	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}


	public int getStartYear() {
		return startYear;
	}


	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}


	public int getEndYear() {
		return endYear;
	}


	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Education [educationId=" + educationId + ", degree=" + degree + ", institution=" + institution
				+ ", fieldOfStudy=" + fieldOfStudy + ", startYear=" + startYear + ", endYear=" + endYear + ", grade="
				+ grade + ", user=" + user + "]";
	}




	
	

}
