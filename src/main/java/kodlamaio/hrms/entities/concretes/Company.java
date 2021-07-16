package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="companies")
@PrimaryKeyJoinColumn(name="user_id")
@EqualsAndHashCode(callSuper = false)



public class Company extends User{
	
	
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
