package com.hello.mvc03.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.mvc03.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CustomerDto> selectList() {

		List<CustomerDto> list = new ArrayList<CustomerDto>();

		try {
			list = sqlSession.selectList(namespace + "selectList");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public CustomerDto selectOne(String id) {

		CustomerDto dto = new CustomerDto();

		try {
			dto = sqlSession.selectOne(namespace + "selectOne", id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public int insert(CustomerDto dto) {

		int res = 0;

		try {
			res = sqlSession.insert(namespace + "insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int update(CustomerDto dto) {
		int res = 0;

		try {
			res = sqlSession.update(namespace + "update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public int delete(String id) {
		int res = 0;

		try {
			res = sqlSession.delete(namespace + "delete", id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
