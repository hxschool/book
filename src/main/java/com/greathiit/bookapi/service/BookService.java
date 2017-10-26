package com.greathiit.bookapi.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greathiit.bookapi.web.BookController;

@Service
@Transactional(readOnly=true)
public class BookService {
	private final static Logger log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Map<String,Object>> getBook(String name){
		String sql = "select * from 馆藏书目库  where 题名 is not null and 题名 like ?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, "%"+name+"%");
		log.info("打印查询sql :{} ,参数  :{}",sql,name);
		return list;
	}
	
	public List<Map<String,Object>> getSortBook(String name){
		String sql = "select * from 馆藏书目库  where 题名 is not null and 题名缩写  like ?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, "%"+name+"%");
		log.info("打印查询sql :{} ,参数  :{}",sql,name);
		return list;
	}
	
	public List<Map<String,Object>> getReader(String name){
		String sql = "select * from 读者库  where 姓名 is not null and 姓名  like ?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, "%"+name+"%");
		log.info("打印查询sql :{} ,参数  :{}",sql,name);
		return list;
	}
	
	public List<Map<String,Object>> getReaderByStudentNumber(String studentNumber){
		String sql = "select * from 读者库  where 姓名 is not null and 读者条码  like ?";
		List<Map<String,Object>> list = jdbcTemplate.queryForList(sql, "%"+studentNumber+"%");
		log.info("打印查询sql :{} ,参数  :{}",sql,studentNumber);
		return list;
	}
	
	
}
