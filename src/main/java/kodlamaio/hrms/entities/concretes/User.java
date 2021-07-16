package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email(message = "Lütfen geçerli bir mail adresi giriniz")
	@NotBlank(message = "Mail alanı boş bırakılamaz")
	@Column(name="email")
	private String email;
	
	@Size(min = 6,max = 10,message = "Şifre 6-12 karakter uzunluğunda olmalıdır")
	@NotBlank(message="Şifre alanı boş bırakılamaz")
	@Column(name="password")
	private String password;
	
	@NotBlank(message="Şifre alanı boş olamaz")
	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	private String passwordRepeat;
	
	
}
