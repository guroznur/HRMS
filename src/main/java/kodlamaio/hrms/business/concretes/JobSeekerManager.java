package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	@Autowired
	private FieldService<JobSeeker> fieldService;
	

	public JobSeekerManager(FieldService<JobSeeker> fieldService) {
		super();
		this.fieldService = fieldService;
	}

	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return fieldService.getAll();
			
	}
	
	@Override
	public Result add(JobSeeker jobSeeker) {
		return fieldService.verifyData(jobSeeker);

	}

	
}
