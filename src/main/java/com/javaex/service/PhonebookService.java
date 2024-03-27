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

	// 리스트 가져오기
	public List<PersonVo> exePhonebookList() {
		System.out.println("PhonebookService.exePhonebookList()");

		List<PersonVo> personList = phonebookDao.phonebookSelectList();
		return personList;
	}

	// 저장 등록
	public PersonVo exeAddandGuest(PersonVo personVo) {
		System.out.println("PhonebookService.exeAddandGuest()");

		// 등록
		int count = phonebookDao.insertSelectKey(personVo);

		// personId 의 데이터 가져오기
		// personId값 확인
		int no = personVo.getPersonId();
		// personId데이터 가져오기

		PersonVo pVo = phonebookDao.phonebookSelectOne(no);
		return pVo;
	}

	// 삭제
	public int exeRemove(PersonVo personVo) {
		System.out.println("PhonebookService.exeRemove()");

		int count = phonebookDao.phonebookDelete(personVo);
		return count;
	}

	// 회원정보수정폼(1명 데이터가져오기)
	public PersonVo exeModifyForm(int no) {
		System.out.println("UserService.exeModifyForm()");

		PersonVo personVo = phonebookDao.phonebookSelectOne(no);
		return personVo;
	}

	// 회원정보 수정
	public int exeModify(PersonVo personVo) {
		System.out.println("UserService.exeModify()");

		int count = phonebookDao.userUpdate(personVo);
		System.out.println(personVo);
		return count;
	}

}
