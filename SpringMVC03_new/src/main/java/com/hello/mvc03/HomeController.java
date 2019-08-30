package com.hello.mvc03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hello.mvc03.biz.CustomerBiz;
import com.hello.mvc03.dto.CustomerDto;

@Controller
public class HomeController {

	@Autowired
	private CustomerBiz biz;

	@RequestMapping(value = "/list.do")
	public String selectList(Model model) {

		model.addAttribute("list", biz.selectList());

		return "boardlist";
	}

	@RequestMapping(value = "/selectone.do")
	public String selectOne(Model model, String id) {

		model.addAttribute("dto", biz.selectOne(id));

		return "selectone";
	}

	@RequestMapping(value = "/insert.do")
	public String insert() {

		return "insert";
	}

	@RequestMapping(value = "/insertres.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String insertres(Model model, CustomerDto dto) {

		int res = biz.insert(dto);

		if (res > 0) {
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			return "insert";
		}
	}

	@RequestMapping(value = "/update.do")
	public String update(Model model, String id) {

		model.addAttribute("dto", biz.selectOne(id));

		return "update";
	}

	@RequestMapping(value = "/updateres.do", method = { RequestMethod.POST, RequestMethod.GET })
	public String updateres(Model model, CustomerDto dto) {

		int res = biz.update(dto);

		if (res > 0) {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "selectone";
		} else {
			model.addAttribute("dto", biz.selectOne(dto.getId()));
			return "selectone";
		}
	}

	@RequestMapping(value = "/delete.do")
	public String delete(Model model, String id) {

		int res = biz.delete(id);

		if (res > 0) {
			model.addAttribute("list", biz.selectList());
			return "boardlist";
		} else {
			model.addAttribute("dto", biz.selectOne(id));
			return "selectone";
		}
	}

}
