package com.example.demop.services;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;




import org.springframework.stereotype.Service;

import com.example.demop.model.FormSubmissionDTO;
import com.example.demop.model.ScientificArea;
import com.example.demop.repository.UserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class SaveNewUserService implements JavaDelegate{

	
	@Autowired
	IdentityService identityService;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	ScientificAreaService scienceService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Usao u saveNewUser servis");
	
		 List<FormSubmissionDTO> userInfo = (List<FormSubmissionDTO>)execution.getVariable("registrationData");
		 
		 HashMap<String, Object> map = this.mapListToDto(userInfo);
		 
		 ObjectMapper mapper= new ObjectMapper();
		 mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		 com.example.demop.model.User newUser1= mapper.convertValue(map, com.example.demop.model.User.class);
		 
		 User user = identityService.newUser("NoviUser");
		 user.setEmail(newUser1.getMail());
		 user.setFirstName(newUser1.getName());
		 user.setLastName(newUser1.getSurname());
		 user.setPassword(newUser1.getPassword());
		 user.setId(newUser1.getUsername());
		 com.example.demop.model.User newUser = new com.example.demop.model.User();  

		 List<ScientificArea> allAreas = scienceService.getAll();
		  for(ScientificArea area : allAreas){
			  for(String selectedArea: (ArrayList<String>) map.get("branches")){
				  String idS=area.getId().toString();
				  if(idS.equals(selectedArea)){
					  newUser1.getScientificAreas().add(area);
				  }
			  }
		  }
		 
		 
		/* for(FormSubmissionDTO item: userInfo){
			  String fieldId = item.getFieldId();
			  String fieldValue = item.getFieldValue();
			 
			  if(fieldId.equals("name")){
				  user.setFirstName(fieldValue);
				  newUser.setName(fieldValue);
			  }else if(fieldId.equals("surname")){
				  user.setLastName(fieldValue);
				  newUser.setSurname(fieldValue);
			  }else if(fieldId.equals("email")){
				  user.setEmail(fieldValue);
				  newUser.setMail(fieldValue);
			  }else if(fieldId.equals("password")){
				  String encrPass = "";
				  try {
					  encrPass = userService.encrypt(fieldValue);
					} catch (NoSuchAlgorithmException e) {
						// TODO Auto-generated catch block
						encrPass=fieldValue;
						e.printStackTrace();
					}
				    
				  user.setPassword(encrPass);
				  newUser.setPassword(encrPass);
			  }else if(fieldId.equals("city")){
				  newUser.setCity(fieldValue);
			  }else if(fieldId.equals("country")){
				  newUser.setCountry(fieldValue);
			  }else if(fieldId.equals("title")){
				  newUser.setTitle(fieldValue);
			  }else if(fieldId.equals("reviewerFlag")){
				  newUser.setReviewerFlag(false);
				  if(fieldValue.equals("true")){
					  newUser.setReviewerFlag(true);
				  }
			  }else if(fieldId.equals("username")){ 
				  System.out.println("Username je ");
				  newUser.setUsername(fieldValue);
				  user.setId(fieldValue);
			  }else if(fieldId.equals("branches")){
				  List<ScientificArea> allAreas = scienceService.getAll();
				  for(ScientificArea area : allAreas){
					  for(String selectedArea:item.getCategories()){
						  String idS=area.getId().toString();
						  if(idS.equals(selectedArea)){
							  newUser.getScientificAreas().add(area);
							  
						  }
					  }
				  }
			  }else{
				  System.out.println("Nista od ponudjenog");
			  }
		  }*/
		  if (identityService.createUserQuery().userId(user.getId()).singleResult()==null)
			  identityService.saveUser(user);
	      userService.save(newUser1);
	}
	private HashMap<String, Object> mapListToDto(List<FormSubmissionDTO> list)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		for(FormSubmissionDTO temp : list){
			if(temp.getFieldValue()==null)
				map.put(temp.getFieldId(), temp.getCategories());
			else
			map.put(temp.getFieldId(), temp.getFieldValue());
		}
		
		return map;
	}

}
