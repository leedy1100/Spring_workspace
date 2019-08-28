package com.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.dto.MVCBoardDto;

@Repository
public class MVCBoardDaoImp implements MVCBoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<MVCBoardDto> selectList() {

		List<MVCBoardDto> list = jdbcTemplate.query(SELECT_LIST_SQL, new myMapper());

		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {

		MVCBoardDto dto = (MVCBoardDto) jdbcTemplate.queryForObject(SELECT_ONE_SQL, new Object[] { seq },
				new myMapper());

		return dto;
	}

	@Override
	public int insert(MVCBoardDto dto) {

		int res = jdbcTemplate.update(INSERT_SQL, new Object[] { dto.getWriter(), dto.getTitle(), dto.getContent() });

		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {

		int res = jdbcTemplate.update(UPADATE_SQL, new Object[] { dto.getTitle(), dto.getContent(), dto.getSeq() });

		return res;
	}

	@Override
	public int delete(int seq) {

		int res = jdbcTemplate.update(DELETE_SQL, new Object[] { seq });

		return res;
	}

	public static final class myMapper implements RowMapper<MVCBoardDto> {

		@Override
		public MVCBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {

			MVCBoardDto res = new MVCBoardDto();
			res.setSeq(rs.getInt(1));
			res.setWriter(rs.getString(2));
			res.setTitle(rs.getString(3));
			res.setContent(rs.getString(4));
			res.setRegdate(rs.getDate(5));

			return res;
		}
	}
}
