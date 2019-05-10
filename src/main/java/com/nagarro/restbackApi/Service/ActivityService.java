package com.nagarro.restbackApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.restbackApi.Models.Activity;
import com.nagarro.restbackApi.repository.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepository;

	public List<Activity> getAllActivities() {
		// TODO Auto-generated method stub
		return	 activityRepository.findAll();
	}

	public Activity getActivityById(String id) {
		// TODO Auto-generated method stub
		return activityRepository.findById(id).get();
	}

	public void addActivity(Activity activity) {
		// TODO Auto-generated method stub
		if ( activity.getActivityId()== null || activity.getActivityId().equals("")) {
			activity.setActivityId(activity.generateActivityId());
		}
		activityRepository.save(activity);
		
	}

	public void updateActivity(String id, Activity newActivity) {
		// TODO Auto-generated method stub
		Activity old=activityRepository.getOne(id);
		if(old!=null) 
		{
			newActivity.setActivityId(old.getActivityId());
			newActivity.setBatch(old.getBatch());
			newActivity.setLevel(old.getLevel());
			if(newActivity.getDescription().equals(""))
			{
				newActivity.setDescription(old.getDescription());
			}
			if(newActivity.getQualifyPoints()==0)
			{
				newActivity.setQualifyPoints(old.getQualifyPoints());
			}
			if(newActivity.getMaxAttempts()==0)
			{
				newActivity.setMaxAttempts(old.getMaxAttempts());
			}
			if(newActivity.getName().equals(""))
			{
				newActivity.setName(old.getName());
			}
			activityRepository.save(newActivity);
		}
		else {
			System.out.println("Error ");
		}
	}

	public void deleteActivity(String id) {
		// TODO Auto-generated method stub
		Activity old=activityRepository.getOne(id);
		System.out.println();
		activityRepository.delete(old);
	}
}
