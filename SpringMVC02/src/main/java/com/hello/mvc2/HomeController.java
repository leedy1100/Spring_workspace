package com.hello.mvc2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc2.model.HelloBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private HelloBiz biz;

	/**
	 * Simply selects the home view to render by returning its name.
	 * method = RequestMethod.GET // get방식으로 넘어올때 받아준다는 뜻
	 */
	@RequestMapping(value="/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/hello.do")
	public String getHello(Model model) {

		model.addAttribute("message", biz.getHello());

		return "hello";
	}
	// ?name=spring 넘어오는 이름 name(key)랑 변수 이름이랑 같으면@RequestParam("name") 안써줘도 됨
	@RequestMapping("/bye.do")
	public String getBye(Model model, String name) {

		model.addAttribute("message", "bye," + name);

		return "bye";
	}

}
