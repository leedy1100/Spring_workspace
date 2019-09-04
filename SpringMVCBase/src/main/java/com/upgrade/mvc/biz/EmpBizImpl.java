package com.upgrade.mvc.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upgrade.mvc.dao.EmpDao;
import com.upgrade.mvc.dto.EmpDto;

@Service
public class EmpBizImpl implements EmpBiz {
	
	@Autowired
	private EmpDao dao;

	@Override
	public List<EmpDto> selectList() {
		return dao.selectList();
	}

	@Override
	public EmpDto selectOne(int empno) {
		return dao.selectOne(empno);
	}

	@Override
	public int insert(EmpDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(EmpDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int empno) {
		return dao.delete(empno);
	}

}
