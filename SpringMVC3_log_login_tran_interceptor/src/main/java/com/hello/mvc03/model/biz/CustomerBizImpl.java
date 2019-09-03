package com.hello.mvc03.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.mvc03.dto.CustomerDto;
import com.hello.mvc03.model.dao.CustomerDao;

@Service
public class CustomerBizImpl implements CustomerBiz {

	@Autowired
	private CustomerDao dao;

	@Override
	public List<CustomerDto> selectList() {
		return dao.selectList();
	}

	@Override
	public CustomerDto selectOne(String id) {
		return dao.selectOne(id);
	}

	@Override
	public int insert(CustomerDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(CustomerDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(String id) {
		return dao.delete(id);
	}

	@Override
	public CustomerDto login(String id, String pw) {
		return dao.login(id, pw);
	}

	@Override
	@Transactional
	public String test() {
		
		dao.insert(new CustomerDto("1","1","1"));
		
		String test = dao.test();
		test.length();
		
		return test;
	}

}

/*
 
@Transactional (tx:)
-isolation : 별도로 정의하지 않으면 DB의 isolatin level을 따른다.
	<isolation level>
	-default : 데이터베이스에 의존
	-uncommitted : commit 되지 않은 데이터 볼 수 있다.
	-repeatable : 새로운 데이터 입력시 볼 수 있다.
	-serializable : 동일한 데이터에 동시에 두개 이상의 트랜잭션이 수행 불가
	
-propagation : 전파규칙 정의 (기본값 : required)
	-required : 기존 트랜잭션이 존재하면 지원, 없으면 새로운 트랜잭션 시작
	-supports : 기존 트랜잭션이 존재하면 지원, 없으면 트랜잭션 없이
	-madatory : 반드시 트랜잭션 내에서 메서드 실행, 기존 트랜잭션 일시정지
	-not_supported : 기존 트랜잭션 내에서 실행, 없으면 트랜잭션 없이
	-never : mandatory와 반대(반드시 트랜잭션 외부에서 메서드 실행)
	-nested : 트랜잭션이 존재하면 중첩되어 실행, 없으면 새로운 트랜잭션 시작
	
-readOnly : 읽기 전용
-rollbackFor : 정의된 exception에 대해서 rollback 수행(rollbackFor = Exception.class)
-norollbackFor : 정의된 exception에 대해서 rollback 수행 안함
-timeout : 지정한 시간 내에 메서드 수행 완료되지 않으면 rollback(기본값 -1 = notimeout)
* mybatis에서 timeout이 존재하면 중첩되서 실행, 없으면 새로운 트랜잭션 시작

*/






