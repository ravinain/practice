package com.practice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Course {

	private String name;
	private List<Subject> subjects;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	/**
	 * @Qualifier does not work with collection type, in place of it we should
	 *            use @Resource annotation. However, this is only for annotation
	 *            qualifier. If you want to use qualifier in xml configuration
	 *            then it will work. See commented part in xml. If you want to
	 *            test then comment @Resource in Course.java file and uncomment
	 *            the qualifier statement in beans.xml file.
	 * @param subjects
	 */
	@Autowired
	@Resource(name = "subjectList1")
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
}
