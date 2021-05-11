package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="companies")
public class Company {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="company_website")
	private String companyWebsite;
	
	@Column(name="company_phone_number")
	private String companyPhoneNumber;

}
