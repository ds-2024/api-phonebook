package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;


@Service
public class PhonebookService {
	
	@Autowired
	private PhonebookDao phonebookDao;
	
	//리스트 가져오기
		public List<PersonVo> exePhonebookList(){
			System.out.println("PhonebookService.exePhonebookList()");
			
			List<PersonVo> personList = phonebookDao.phonebookSelectList();
			return personList;
		}

}
