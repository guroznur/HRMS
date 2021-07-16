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
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class CompanyFieldManager implements FieldService<Company>{

	
	@Autowired
	private CompanyDao companyDao;
	private UserDao userDao;
	
	public CompanyFieldManager(CompanyDao companyDao,UserDao userDao) {
		super();
		this.companyDao = companyDao;
		this.userDao = userDao;
	}

	@Override
	public Result verifyData(Company company) {
		if(!checkMail(company.getEmail())) {
			return new ErrorResult("Email daha önce kullanıldı");
		}
		this.companyDao.save(company);
		return new SuccessResult("Kayıt başarılı");
		
	}

	private Boolean checkMail(String email) {
		if(this.userDao.findByEmail(email) == null) {
			return true;
		}
		return false;
	}
	@Override
	public DataResult<List<Company>>getAll() {
		
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(),"İşverenler listelendi");
	}
	

}
