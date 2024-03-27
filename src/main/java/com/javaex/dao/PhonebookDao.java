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

	// 리스트 가져오기
	public List<PersonVo> phonebookSelectList() {
		System.out.println("PhonebookDao.phonebookSelectList()");

		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");

		System.out.println(personList);
		return personList;
	}

	// 글 저장 selectKey
	public int insertSelectKey(PersonVo personVo) {
		System.out.println("PhonebookDao.insertSelectKey()");

		int count = sqlSession.insert("phonebook.insertSelectKey", personVo);
		return count;
	}

	// 저장1개 가져오기
	public PersonVo phonebookSelectOne(int no) {
		System.out.println("PhonebookDao.phonebookSelectOne()");
		System.out.println(no);
		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		System.out.println(personVo);
		return personVo;
	}

	// 삭제
	public int phonebookDelete(PersonVo personVo) {
		System.out.println("PhonebookDao.phonebookDelete()");

		int count = sqlSession.delete("phonebook.delete", personVo);
		return count;
	}

	// no로 한명데이터 가져오기(회원정보수정 폼)
	public PersonVo userSelectOneByNo(int no) {

		System.out.println("PhonebookDao.userSelectOneByNo()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOneByNo", no);
		return personVo;
	}

	// 회원정보수정
	public int userUpdate(PersonVo personVo) {

		System.out.println("PhonebookDao.userUpdate()");
		int count = sqlSession.update("phonebook.update", personVo);

		return count;
	}

}
