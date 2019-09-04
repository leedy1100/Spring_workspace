package com.upgrade.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.upgrade.mvc.dto.EmpDto;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<EmpDto> selectList() {

		List<EmpDto> list = new ArrayList<EmpDto>();

		try {
			list = sqlSession.selectList(namespace + "selectList");
		} catch (Exception e) {
			System.out.println("SELECT LIST ERROR");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public EmpDto selectOne(int empno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EmpDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int empno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
