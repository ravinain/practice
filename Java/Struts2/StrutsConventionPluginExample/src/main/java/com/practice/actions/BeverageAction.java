package com.practice.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ModelDriven;
import com.practice.bo.Beverage;

public class BeverageAction implements ModelDriven<Beverage> {

	Beverage beverage = new Beverage();

	public Beverage getModel() {
		return beverage;
	}

	// If no action has been specified then it will look for
	// beverage-success.jsp in /WEB-INF/content folder.
	// the Action suffix will be removed as it denotes Action.
	public String execute() {
		beverage.setName("Unknown");
		beverage.setPrice(0.0);
		return "success";
	}

	// This action will look for coffee.jsp page in /WEB-INF/content/beverage/
	// folder.
	@Action(value = "/beverage/coffee")
	public String coffee() {
		beverage.setName("Coffee");
		beverage.setPrice(20.00);
		return "success";
	}

	@Action(value = "/beverage/tea", results = { @Result(name = "success", location = "/WEB-INF/content/beverage/teaAndMilk.jsp") })
	public String tea() {
		beverage.setName("Tea");
		beverage.setPrice(15.00);
		return "success";
	}

	@Action(value = "/beverage/milk", results = { @Result(name = "success", location = "/WEB-INF/content/beverage/teaAndMilk.jsp") })
	public String milk() {
		beverage.setName("Milk");
		beverage.setPrice(18.00);
		return "success";
	}

	@Action(value = "/index", results = { @Result(name = "success", location = "/index.jsp", type = "redirect") })
	public String index() {
		return "success";
	}
}
