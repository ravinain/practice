package org.school.controller;

import java.util.List;

import org.school.exception.RestException;
import org.school.model.Staff;
import org.school.response.Message;
import org.school.response.MessageList;
import org.school.service.StaffService;
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
public class StaffController {

	@Autowired
	StaffService staffService;
	
	@RequestMapping(value="/staffs", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getStaffs() {
		List<Staff> staffs = staffService.getStaffs();
		if(!staffs.isEmpty()) {
			return new ResponseEntity<List<Staff>>(staffs, HttpStatus.OK);
		}
		return new ResponseEntity<Message>(new Message("error", "No staff found"), HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/staff/{id}", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getStaff(@PathVariable("id") int id) {
		Staff staff = staffService.getStaff(id);
		if(staff != null) {
		return new ResponseEntity<Staff>(staffService.getStaff(id), HttpStatus.OK);
		}
		return new ResponseEntity<Message>(new Message("error", "Staff does not exists for ID : "+id), HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value="/staff/add", method=RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> addStaff(@RequestBody Staff staff, BindingResult result) {
		MessageList messageList = staffService.addStaff(staff, result);
		if (!messageList.getMessages().isEmpty()) {
			return new ResponseEntity<MessageList>(messageList, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/staff/update/{id}", method=RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> updateStaff(@PathVariable("id") int id, @RequestBody Staff staff, BindingResult result) {
		MessageList messageList = staffService.updateStaff(id, staff, result);
		if (!messageList.getMessages().isEmpty()) {
			return new ResponseEntity<MessageList>(messageList, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}
	
	@RequestMapping(value="/staff/delete/{id}", method=RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> deleteStaff(@PathVariable("id") int id) {
		if(staffService.deleteStaff(id)) {
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
