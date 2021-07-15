package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="companies")
@AllArgsConstructor
@NoArgsConstructor
public class Company extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@NotBlank(message = "Şirket ismi alanı boş bırakılamaz")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message = "Web sitesi alanı boş bırakılamaz")
	@Column(name="company_website")
	private String companyWebsite;
	
	@NotBlank(message = "Telefon numarası alanı boş bırakılamaz")
	@Column(name="company_phone_number")
	private String companyPhoneNumber;

}
