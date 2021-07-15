package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;

public interface JobSeekerValidationService {
	Result verify(int userId);
}
