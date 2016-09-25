package org.school.controller;

import java.util.List;

import javax.validation.Valid;

import org.school.exception.RestException;
import org.school.model.Student;
import org.school.response.Message;
import org.school.response.MessageList;
import org.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getStudents() {
		List<Student> students = studentService.getStudents();
		if(students.isEmpty()) {
			return new ResponseEntity<Message>(new Message("student", "No student found!"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@RequestMapping(value="/student/{id:[1-9]{1}[0-9]*}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getStudent(@PathVariable("id") int id) {
		Student student = studentService.getStudent(id);
		if(student == null) {
			return new ResponseEntity<Message>(new Message("student", "Student not found for ID : "+id), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@RequestMapping(value="/student/add", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addStudent(@RequestBody @Valid Student student, BindingResult result) {
		MessageList messageList = studentService.addStudent(student, result);
		if(messageList.getMessages().isEmpty()) {
			System.out.println("Student name : "+student.getName());
			return new ResponseEntity<Student>(student, HttpStatus.CREATED);
		}
		return new ResponseEntity<MessageList>(messageList, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/student/update/{id:[1-9]{1}[0-9]*}", method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> updateStudent(@PathVariable("id") int id, @Valid @RequestBody Student student, BindingResult result) {
		MessageList messageList = studentService.updateStudent(id, student, result); 
		if(messageList.getMessages().isEmpty()) {
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		return new ResponseEntity<MessageList>(messageList, HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/student/delete/{id:[1-9]{1}[0-9]*}", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
		if(studentService.deleteStudent(id)) {
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(id, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RestException.class)
	public ResponseEntity<?> handleException(RestException restException) {
		restException.printStackTrace();
		return new ResponseEntity<Message>(new Message("error", "Error CD : "+restException.getErrorCd()+restException.getErrorMsg()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleAllException(Exception exception) {
		String errorMsg = exception.getMessage() == null ? "Exception occurred, see log for details."
				: exception.getMessage();
		exception.printStackTrace();
		return new ResponseEntity<Message>(new Message("error", errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
