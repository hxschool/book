package com.greathiit.bookapi.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.greathiit.bookapi.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	private BookService bookService;
	@RequestMapping(value = "/getBook")
	@ResponseBody
	public List<Map<String,Object>> getBook(String bookname){
		return bookService.getBook(bookname);
	}
	
	@RequestMapping(value = "/getSortBook")
	@ResponseBody
	public List<Map<String,Object>> getSortBook(String sortBookname){
		return bookService.getSortBook(sortBookname);
	}
	
	@RequestMapping(value = "/getReader")
	@ResponseBody
	public List<Map<String,Object>> getReader(String name){
		return bookService.getReader(name);
	}
	
	@RequestMapping(value = "/getReaderByStudentNumber")
	@ResponseBody
	public List<Map<String,Object>> getReaderByStudentNumber(String studentNumber){
		return bookService.getReaderByStudentNumber(studentNumber);
	}
	
}
