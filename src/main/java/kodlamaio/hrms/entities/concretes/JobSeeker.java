package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="user_id")
@EqualsAndHashCode(callSuper = false)

public class JobSeeker extends User{
	
	
	@NotBlank(message = "İsim alanı boş bırakılamaz")
	@Size(min=3,message ="En az 3 karakter girmelisiniz")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Soy isim alanı boş olamaz")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "TC Kimlik numarası alanı boş olamaz")
	@Size(min=11 , max=11, message="Tc Kimlik numarası 11 hane olmalıdır")
	@Column(name="identity_number")
	private String identityNumber;
	
	@NotBlank(message = "Doğum yılı alanı boş bırakılamaz")
	@Column(name="birth_year")
	private String birthYear;

}
