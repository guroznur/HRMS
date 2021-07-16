package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Company;

@Service
public class CompanyManager implements CompanyService{

	@Autowired
	private FieldService<Company> fieldService;
	
	
	public CompanyManager(FieldService<Company> fieldService) {
		super();
		this.fieldService = fieldService;
	}
	@Override
	public DataResult<List<Company>> getAll() {
		
		return fieldService.getAll();

	}
	@Override
	public Result add(Company company) {
		
		return fieldService.verifyData(company);
				
	}

}
