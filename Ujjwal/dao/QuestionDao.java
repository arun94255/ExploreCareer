package dao;

import java.util.List;

import org.hibernate.Criteria;
//import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javassist.bytecode.Descriptor.Iterator;
import model.Question;
@Repository
public class QuestionDao {

	 @Autowired
	 private SessionFactory sessionFactory;
	 

	 protected Session getSession(){
	  return sessionFactory.getCurrentSession();
	 }

	 
	 
	 public void f1() {
			System.out.println(sessionFactory==null);
	 }


	public int AskQuestion(Question q) {
		Session y =sessionFactory.openSession();
		Transaction t = y.beginTransaction();
		System.out.println(q.getQuestion()+"   "+q.getRelatedAreaOfQuestion());
		
		y.save(q);
		t.commit();
		y.close();
		return 0;
	}



	public List displayMyQuestions(String a) {
		Session y =sessionFactory.openSession();
		Transaction t = y.beginTransaction();
		Criteria c=y.createCriteria(Question.class);
		c.add(Restrictions.eq("askerEmail", a));
		List<Question> results = (List<Question>)c.list();
		System.out.println("Display My Question");
		y.close();
		//System.out.println(results.size());
		//System.out.println(results.getId());
		return results; 
		
	
	}



	public List unAnsweredQuestion() {
		Session y =sessionFactory.openSession();
		Transaction t = y.beginTransaction();
		Criteria c=y.createCriteria(Question.class);
		c.add(Restrictions.isNull("answer"));
		List<Question> results = (List<Question>)c.list();
		System.out.println("Display unAnsweredQuestion");
		return results;
		/*String hql = " SELECT A.question FROM Question A where A.answer=NULL";	
		Query query = (Query) y.createQuery(hql);
		List results = query.list();
		return results;*/
		
	}



	public List answeredQuestion(String a) {
		Session y =sessionFactory.openSession();
		Transaction t = y.beginTransaction();
		
		Criteria c=y.createCriteria(Question.class);
		c.add(Restrictions.eq("replierEmail",a));
		List<Question> results = (List<Question>)c.list();
		System.out.println("Display My answeredQuestion");
		return results;
		
		/*String hql = " SELECT A.question FROM Question A where A.answer!=NULL";	
		Query query = (Query) y.createQuery(hql);
		List results = query.list();
		return results;*/
	}



	}	
	 

