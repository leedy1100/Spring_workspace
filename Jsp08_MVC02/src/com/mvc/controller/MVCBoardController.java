package com.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.biz.MVCBoardBizImp;
import com.mvc.dto.MVCBoardDto;

@Controller
public class MVCBoardController {

	@Autowired
	private MVCBoardBizImp biz;

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
