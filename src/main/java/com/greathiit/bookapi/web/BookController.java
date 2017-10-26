package com.greathiit.bookapi.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greathiit.bookapi.service.BookService;

@Controller
@RequestMapping(value = "/api")
public class BookController {
	private final static Logger log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	private BookService bookService;
	@RequestMapping(value = "/getBook")
	@ResponseBody
	public List<Map<String,Object>> getBook(String bookname){
		log.info("查询书名,请求参数:{}",bookname);
		return bookService.getBook(bookname);
	}
	
	@RequestMapping(value = "/getSortBook")
	@ResponseBody
	public List<Map<String,Object>> getSortBook(String sortBookname){
		log.info("查询书名缩写,请求参数:{}",sortBookname);
		return bookService.getSortBook(sortBookname);
	}
	
	@RequestMapping(value = "/getReader")
	@ResponseBody
	public List<Map<String,Object>> getReader(String name){
		log.info("查询读者信息,请求参数:{}",name);
		return bookService.getReader(name);
	}
	
	@RequestMapping(value = "/getReaderByStudentNumber")
	@ResponseBody
	public List<Map<String,Object>> getReaderByStudentNumber(String studentNumber){
		log.info("查询读者信息,通过学号查询请求参数:{}",studentNumber);
		return bookService.getReaderByStudentNumber(studentNumber);
	}
	
}
