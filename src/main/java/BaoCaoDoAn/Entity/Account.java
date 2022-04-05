package BaoCaoDoAn.Entity;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import BaoCaoDoAn.validator.phone;

import javax.validation.constraints.Pattern;

public class Account {
	
	private int id;


	@Length(min = 5, max = 50, message = "Only Letter is min 5 max 50")
	private String name;

	
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@fpt.edu.vn$", message = "Email must contain @fpt.edu.vn")
	private String mail;

	@NotEmpty(message = "The password is not null")
	private String password;

	private int group_id;

	@phone(message = "The phone number is wrong format")
	private String phone;

	private String role;

	private Boolean isLeader;

	private PointDetail pointDetailForReport;

	private int statusPoint;

	private String gender;
	private String group_name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public String setMail(String mail) {
		return this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getIsLeader() {
		return isLeader;
	}

	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}

	public PointDetail getPointDetailForReport() {
		return pointDetailForReport;
	}

	public void setPointDetailForReport(PointDetail pointDetailForReport) {
		this.pointDetailForReport = pointDetailForReport;
	}

	public int getStatusPoint() {
		return statusPoint;
	}

	public void setStatusPoint(int statusPoint) {
		this.statusPoint = statusPoint;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

}
