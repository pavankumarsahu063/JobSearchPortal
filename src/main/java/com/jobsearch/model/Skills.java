package com.jobsearch.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "skill_id")
	private int skillId;
	@Column(name = "skill_name")
	private String skillname;
	@Column(name="proficiency_level")
	private String proficiencylevel;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) // Foreign key reference
	private Users user;


	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	public String getProficiencylevel() {
		return proficiencylevel;
	}

	public void setProficiencylevel(String proficiencylevel) {
		this.proficiencylevel = proficiencylevel;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Skills [id=" + skillId + ", skillname=" + skillname + ", proficiencylevel=" + proficiencylevel + ", users="
				+ user + "]";
	}	
}
