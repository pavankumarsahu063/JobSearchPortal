package com.jobsearch.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="basicinformation")
public class BasicInformation {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
	    private String phone;
	    private String email;
	    private String dob;
	    private String gender;
	    private String location;
	    @Column(name="externallink")
	    private String externalLink;
	    @OneToOne
	    @JoinColumn(name = "users_id")
	    private Users users;
	    
	    public Users getUsers() { return users; }
	    public void setUsers(Users users) { this.users = users; }
	    public String getPhone() { return phone; }
	    public void setPhone(String phone) { this.phone = phone; }
	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }
	    public String getDob() { return dob; }
	    public void setDob(String dob) { this.dob = dob; }
	    public String getGender() { return gender; }
	    public void setGender(String gender) { this.gender = gender; }
	    public String getLocation() { return location; }
	    public void setLocation(String location) { this.location = location; }
	    public String getExternalLink() { return externalLink; }
	    public void setExternalLink(String externalLink) { this.externalLink = externalLink; }
	}
