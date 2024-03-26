package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;


@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//리스트 가져오기
		public List<PersonVo> phonebookSelectList() {
			System.out.println("PhonebookDao.phonebookSelectList()");

			List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

			System.out.println(personList);
			return personList;
		}

}
