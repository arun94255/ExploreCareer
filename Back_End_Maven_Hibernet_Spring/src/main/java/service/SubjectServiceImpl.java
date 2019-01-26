package service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import config.HibernateConfig;
import dao.SubjectDaoImpl;

import model.Subject;
@Service
@Configuration
@ComponentScan("dao") 
public class SubjectServiceImpl implements SubjectInterface{
	@Autowired
    private  SubjectDaoImpl objSubjectDaoImpl;
	private AnnotationConfigApplicationContext contex;
	
	/*public SubjectServiceImpl() {
		contex=new AnnotationConfigApplicationContext(HibernateConfig.class);
		 objSubjectDaoImpl=contex.getBean(SubjectDaoImpl.class);

	}*/
	public boolean checkConfiguration() {
		System.out.println(12);
		return objSubjectDaoImpl.checkConfiguration();
	}
	public int addSubject(Subject subject) {
		return objSubjectDaoImpl.addSubject(subject)
				;
	}
	public int updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		return objSubjectDaoImpl.updateSubject(subject);
	}
	public int deleteSubject(Subject subject) {
		// TODO Auto-generated method stub
		return objSubjectDaoImpl.deleteSubject(subject);
	}
	public Subject showSubject(Subject subject) {
		// TODO Auto-generated method stub
		return objSubjectDaoImpl.showSubject(subject);
	}/*
	public static void main(String[] args) {
		 AnnotationConfigApplicationContext contex=new AnnotationConfigApplicationContext(HibernateConfig.class);
		 objSubjectDaoImpl=contex.getBean(SubjectDaoImpl.class);
		
		 
		 
		System.out.println(objSubjectDaoImpl.checkConfiguration());/*
		Subject subject=new Subject();
		subject.setName("Maths");
		subject.setDetails("it is best sub");
		System.out.println(objSubjectDaoImpl.addSubject(subject));
		System.out.println(objSubjectDaoImpl.deleteSubject(subject)); 
		subject.setDetails("dfghdfgjeh");
		System.out.println(objSubjectDaoImpl.updateSubject(subject));
		
		System.out.println(objSubjectDaoImpl.showSubject(subject));
		
	
	}
*/
	public List<Subject> getSubjectList() {
		// TODO Auto-generated method stub
		return objSubjectDaoImpl.getSubjectList();
	}
}
