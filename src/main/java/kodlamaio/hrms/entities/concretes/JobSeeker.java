package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="job_seekers")
public class JobSeeker {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String LastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_year")
	private String birthYear;

}
