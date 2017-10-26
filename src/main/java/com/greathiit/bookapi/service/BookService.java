package com.greathiit.bookapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class BookService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getBook(String name){
		String sql = "select * from 馆藏书目库  where 题名 is not null and 题名 like ?";
		return jdbcTemplate.queryForList(sql, "%"+name+"%");
	}
	
	public List<Map<String,Object>> getSortBook(String name){
		String sql = "select * from 馆藏书目库  where 题名 is not null and 题名缩写  like ?";
		return jdbcTemplate.queryForList(sql, "%"+name+"%");
	}
	
	public List<Map<String,Object>> getReader(String name){
		String sql = "select * from 读者库  where 姓名 is not null and 姓名  like ?";
		return jdbcTemplate.queryForList(sql, "%"+name+"%");
	}
	
	public List<Map<String,Object>> getReaderByStudentNumber(String studentNumber){
		String sql = "select * from 读者库  where 姓名 is not null and 读者条码  like ?";
		return jdbcTemplate.queryForList(sql, "%"+studentNumber+"%");
	}
	
	
}
