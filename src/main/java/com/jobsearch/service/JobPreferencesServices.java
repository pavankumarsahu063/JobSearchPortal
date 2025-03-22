package com.jobsearch.service;

import com.jobsearch.model.JobPreferences;

public interface JobPreferencesServices {
	void saveJobPreferences(JobPreferences jobPreferences);
	JobPreferences getJobPreferences(int userId);
	void deleteJobPreferance(int prefId);
	

}
