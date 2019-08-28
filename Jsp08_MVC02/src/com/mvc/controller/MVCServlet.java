package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImp;
import com.mvc.dto.MVCBoardDto;


@WebServlet(urlPatterns = {"/selectall","/selectone","/insert","/insertres","/update","/updateres","/delete"})
public class MVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MVCBoardBiz biz;	
	
	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		biz = new MVCBoardBizImp();
		
		String command = request.getRequestURI();
		System.out.println("["+command+"]");
		
		if(command.endsWith("/selectall")) {
			doSelectAll(request,response);	
		
		}else if(command.endsWith("/selectone")) {
			doSelOne(request,response);
		
		}else if(command.endsWith("/insert")) {
			dispatch(request, response, "insert.jsp");
		
		}else if(command.endsWith("/insertres")) {
			doInsertRes(request,response);
		
		}else if(command.endsWith("/update")) {
			doUpdate(request,response);
			
		}else if(command.endsWith("/updateres")) {
			doUpdateRes(request,response);
		
		}else if(command.endsWith("/delete")) {
			doDeleteRes(request,response);
		}
	}


	private void doDeleteRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		
		if(res > 0) {
			alert(response, "글 삭제 성공", "selectall");	
		}else {
			alert(response, "글 삭제 실패", "selectone?seq"+seq);
		}
	}

	private void doUpdateRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		
		if(res > 0 ) {
			alert(response, "글 수정 성공", "selectone?seq="+seq);
			
		}else {
			alert(response, "글 수정 실패", "update?seq="+seq);
		}
		
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		request.setAttribute("dto",dto);
		dispatch(request, response, "update.jsp");	
	}

	private void doInsertRes(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.insert(dto);
		
		if(res > 0 ) {
			alert(response, "글 작성 성공", "selectall");
			
		}else {
			alert(response, "글 작성 실패", "insert");
			
		}			
	}

	private void doSelOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		request.setAttribute("dto", dto);
		dispatch(request,response,"selectone.jsp");
	}

	private void doSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MVCBoardDto> list = biz.selectList();
		request.setAttribute("list", list);
		dispatch(request,response,"boardlist.jsp");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getRequest(request,response);
			
		/*
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		MVCBoardBiz biz = new MVCBoardBizImp();
		MVCBoardDto dto = new MVCBoardDto();
	
		if(command.equals("list")) {	
			// 인터페이스라서 안담기니까 ArrayList로 객체생성을 해줘야 값을 넣을수 있음
			List<MVCBoardDto> list = biz.selectList();
			request.setAttribute("list",list);

			dispatch(request, response, "boardlist.jsp");
		
		}else if(command.equals("selectone")){
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			dto = biz.selectOne(seq);
			request.setAttribute("dto", dto);
			dispatch(request,response,"selectone.jsp");
			
		}else if(command.equals("insert")) {
			
			dispatch(request, response, "insert.jsp");
			
		}else if(command.equals("insertres")) {
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			dto.setWriter(writer);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.insert(dto);
			
			if(res > 0 ) {
				alert(response, "글 작성 성공", "mvc.do?command=list");
				
			}else {
				alert(response, "글 작성 실패", "mvc.do?command=insert");
				
			}		
			
		}else if(command.equals("update")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			dto = biz.selectOne(seq);
			request.setAttribute("dto",dto);
			dispatch(request, response, "update.jsp");
			
		}else if(command.equals("updateres")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			
			int res = biz.update(dto);
			
			if(res > 0 ) {
				alert(response, "글 수정 성공", "mvc.do?command=selectone&seq="+seq);
				
			}else {
				alert(response, "글 수정 실패", "mvc.do?command=update&seq="+seq);
			}
			
		}else if(command.equals("delete")) {
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.delete(seq);
			
			if(res > 0) {
				alert(response, "글 삭제 성공", "mvc.do?command=list");
				
			}else {
				alert(response, "글 삭제 실패", "mvc.do?command=selectone&seq"+seq);
				
			}
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	public void alert (HttpServletResponse response, String msg, String url) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println(" <script type=\"text/javascript\">"
				   +"	  alert('"+msg+"');"
				   +"     location.href='"+url+"';" 
		           +" </script> ");
	}
	
}
