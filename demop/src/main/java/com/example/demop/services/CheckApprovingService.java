package com.example.demop.services;

import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demop.model.FormSubmissionDTO;

@Service
public class CheckApprovingService implements JavaDelegate{

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserServiceImpl userImpl;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Usao u checkApproving servis");
		if(execution==null){
			System.out.println("Null exec");
		}
		boolean approvedReviewer = (boolean)execution.getVariable("approvedFlag");
		if(execution.getVariable("approvedFlag")==null){
			System.out.println("Nema variable");
		}
		if(approvedReviewer){
			System.out.println("Odobren");
		}else{
			System.out.println("Nije odobren");
		}
		com.example.demop.model.User reviewer = new com.example.demop.model.User();  
		List<FormSubmissionDTO> userInfo = (List<FormSubmissionDTO>)execution.getVariable("registrationData");
	    String username = "";
		for(FormSubmissionDTO item: userInfo){
			  System.out.println("***************");
			  String fieldId = item.getFieldId();
			  String fieldValue = item.getFieldValue();
			  System.out.println("Id je "+fieldId);
			  System.out.println("vALUE JE "+fieldValue);
			     if(fieldId.equals("username")){ 
					 username = fieldValue;
				  }	
			}
		reviewer = userImpl.findAllUsersByUsername(username).get(0);
		if(reviewer!=null){
			System.out.println("Nije null reviewer");
			if(approvedReviewer){
				reviewer.setType("reviewer");
				userService.save(reviewer);
			}	
		}
		
		
	}

}
