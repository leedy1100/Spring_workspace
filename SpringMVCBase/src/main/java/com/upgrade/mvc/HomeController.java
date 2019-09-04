package com.upgrade.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.upgrade.mvc.biz.EmpBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private EmpBiz biz;

	@RequestMapping("/list")
	public String selectList(Model model) {
		
		model.addAttribute("list",biz.selectList());
		
		return "boardlist";
	}
	
}
