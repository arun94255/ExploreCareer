package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table
public class Stream implements Serializable{
	@Id
	private String streamName;
	private String scope;
	private String link;
	@OneToMany(cascade=CascadeType.PERSIST)
	private	Collection<Subject> subject=new ArrayList<Subject>();
	@ManyToMany(mappedBy="streams")
	private List<Field> fields =new ArrayList<Field>();
	public String getStreamName() {
		return streamName;
	}
	public List<Field> getFields() {
		return fields;
	}
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public Stream() {
		// TODO Auto-generated constructor stub
	}
	public void setStreamName(String streamName) {
		this.streamName = streamName;
	}
	public String getScope() {
		return scope;
	}
	
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Collection<Subject> getSubject() {
		return subject;
	}
	public void setSubject(Collection<Subject> subject) {
		this.subject = subject;
	}
}
