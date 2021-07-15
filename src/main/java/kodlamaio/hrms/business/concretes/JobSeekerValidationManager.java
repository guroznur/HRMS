package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerValidationService;
import kodlamaio.hrms.core.utilities.results.Result;

@Service
public class JobSeekerValidationManager implements JobSeekerValidationService{

	@Override
	public Result verify(int userId) {
		
		return null;
	}

}
