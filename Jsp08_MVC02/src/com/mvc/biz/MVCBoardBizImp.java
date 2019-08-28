package com.mvc.biz;

import java.util.List;

import com.mvc.dao.MVCBoardDaoImp;
import com.mvc.dto.MVCBoardDto;

public class MVCBoardBizImp implements MVCBoardBiz {

	private MVCBoardDaoImp dao = new MVCBoardDaoImp();
	
	@Override
	public List<MVCBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public int insert(MVCBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(MVCBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		return dao.delete(seq);
	}

}
