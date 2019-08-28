package com.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.model.MVCBoardBizImp;
import com.mvc.model.MVCBoardDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private MVCBoardBizImp biz;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/boardlist.do")
	public String selectList(Model model) {

		model.addAttribute("list", biz.selectList());

		return "boardlist";
	}

	@RequestMapping("/insertform.do")
	public String insertForm() {
		return "insert";
	}

	@RequestMapping(value = "/insertres.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String insertRes(@ModelAttribute MVCBoardDto dto, Model model) {

		int res = biz.insert(dto);

		if (res > 0) {
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "insert";
		}
	}

	@RequestMapping("/selectone.do")
	public String selectOne(Model model, int seq) {

		model.addAttribute("dto", biz.selectOne(seq));

		return "selectone";
	}

	@RequestMapping("/update.do")
	public String update(Model model, int seq) {

		model.addAttribute("dto", biz.selectOne(seq));

		return "update";
	}

	@RequestMapping(value = "/updateres.do", method = RequestMethod.POST)
	public String updateres(@ModelAttribute MVCBoardDto dto, Model model) {

		int res = biz.update(dto);

		if (res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "selectone";
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getSeq()));
			return "update";
		}
	}
	
	@RequestMapping("/delete.do")
	public String delete(Model model, int seq) {
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		}else {
			model.addAttribute("dto", biz.selectOne(seq));
			return "selectone";
		}
	}
	
}
