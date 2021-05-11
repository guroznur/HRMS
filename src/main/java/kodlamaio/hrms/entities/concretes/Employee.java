package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;
	
	@Column(name="position_id")
	private int positionId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String LastName;
	
	

}
