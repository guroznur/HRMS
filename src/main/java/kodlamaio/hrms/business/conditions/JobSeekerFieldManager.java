package kodlamaio.hrms.business.conditions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerFieldManager implements FieldService<JobSeeker>{

	@Autowired
	private UserDao userDao;
	private JobSeekerDao jobSeekerDao;

	public JobSeekerFieldManager(JobSeekerDao jobSeekerDao,UserDao userDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.userDao =  userDao;
	}

	@Override
	public Result verifyData(JobSeeker jobSeeker) {
		
		if(!checkIdentityNumber(jobSeeker.getIdentityNumber())) {
			return new ErrorResult("TC kimlik numarası zaten kayıtlı");
		}
		
		
		 if(!checkMail(jobSeeker.getEmail())) {
			return new ErrorResult("Email daha önce kullanıldı");
		}
		
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kayıt başarılı");
		
	}
	private Boolean checkIdentityNumber(String identitNumber) {
		if(this.jobSeekerDao.findByIdentityNumber(identitNumber) == null) {
			return true;
		}
		return false;
	}
	
	private Boolean checkMail(String email) {
		if(this.userDao.findByEmail(email) == null) {
			return true;
		}
		return false;
	}
	
	//Regex ve şifre tekrarı bilgileri eklenecek
	//private Result checkMailRegex(User user) {
		//String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		//Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		//Matcher matcher = pattern.matcher(user.getEmail());
		//if(!matcher.find()) {
			//return new ErrorResult("Lütfen geçerli bir email giriniz");
		//}
		//return new SuccessResult();
	//}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar listelendi");
	
	}
}
