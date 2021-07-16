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
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionFieldManager implements FieldService<JobPosition>{

	@Autowired
	private JobPositionDao jobPositionDao;

	public JobPositionFieldManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public Result verifyData(JobPosition jobPosition) {
		
		if(!checkJobPositionName(jobPosition.getJobName())) {
			return new ErrorResult("İş pozisyonu zaten mevcut");
			
		}
		
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("İş pozisyonu eklendi");
			
	}
	private Boolean checkJobPositionName(String jobName) {
		if(this.jobPositionDao.findByJobName(jobName).isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"İş pozisyonları listelendi");
	}


}
