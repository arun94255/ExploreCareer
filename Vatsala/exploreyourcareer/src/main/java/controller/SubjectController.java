package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import config.HibernateConfig;
import dao.BranchDaoImpl;
import model.Branch;
import model.Subject;
import service.FieldServiceImpl;
import service.SubjectServiceImpl;



@RestController
public class SubjectController {
 @Autowired
SubjectServiceImpl subjectService;
 
 public @ResponseBody boolean checkConfiguration(){
	 AnnotationConfigApplicationContext contex=new AnnotationConfigApplicationContext(HibernateConfig.class);
	 subjectService=contex.getBean(SubjectServiceImpl.class);	
	 boolean status = subjectService.checkConfiguration();
	 System.out.println(subjectService.checkConfiguration());	  
  return status;
 }
		 
		 @RequestMapping(value="/subject/", method=RequestMethod.GET, headers="Accept=application/json")
		 public @ResponseBody Subject showSubject(@RequestBody Subject subject) {
		  Subject subjectobj = subjectService.showSubject(subject);
		  
		  return subjectobj;
		 }
		 
		 @RequestMapping(value="/add/", method=RequestMethod.POST)
		 public @ResponseBody Subject add(@RequestBody Subject subject){
			 subjectService.addSubject(subject);
		  return subject;
		 }
		 
		 @RequestMapping(value="/update/{name}", method=RequestMethod.PUT)
		 public @ResponseBody Subject update(@PathVariable("name") String name, @RequestBody Subject subject){
			 subject.setName(name);
			
			subjectService.updateSubject(subject);
		  
		  return subject;
		 }
		 
		 @RequestMapping(value="/delete/{name}", method=RequestMethod.DELETE)
		 public @ResponseBody Subject delete(@RequestBody Subject subject){
			 subjectService.deleteSubject(subject);
			return subject;
		  
		 }	 
	}


