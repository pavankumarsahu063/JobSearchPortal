package com.jobsearch.model;

import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "employment")
public class WorkExprience {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long employmentId; 
		@Column(name = "company_name")
	    private String companyName;
		@Column(name = "designation")
	    private String designation;
		@Column(name = "start_date")
	    private String startDate;
		@Column(name = "end_date")
	    private String endDate;

	    @Column(length = 1000,name = "description")
	    private String description;

	    @ManyToOne
	    @JoinColumn(name = "user_id") 
	    private Users user;

		public Long getEmploymentId() {
			return employmentId;
		}

		public void setEmploymentId(Long employmentId) {
			this.employmentId = employmentId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public String getStartDate() {
			return startDate;
		}

		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}

		public String getEndDate() {
			return endDate;
		}

		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Users getUser() {
			return user;
		}

		public void setUser(Users user) {
			this.user = user;
		}
	    
	    

}
