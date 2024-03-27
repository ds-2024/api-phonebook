package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.PersonVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PhonebookController {

	@Autowired
	private PhonebookService phonebookService;

	// 리스트
	// @ResponseBody
	@GetMapping(value = "/api/persons") // @GetMapping)RequestMethod.GET 안써줘도 되고 import해야함
	public List<PersonVo> list() {
		System.out.println("PhonebookController.list()");

		List<PersonVo> personList = phonebookService.exePhonebookList();

		System.out.println(personList);

		return personList;
	}

	// 저장 등록
	// @ResponseBody -> @RestController
	@PostMapping(value = "/api/persons") // 주소 같으니까 get post 구분.post는 저장개
	public PersonVo add(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.add()");

		PersonVo pVo = phonebookService.exeAddandGuest(personVo);

		return pVo;
	}

	// 삭제
	// @ResponseBody
	@DeleteMapping(value = "/api/persons/{personId}")
	public String remove(@RequestBody PersonVo personVo, @PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.remove()");

		//personVo.setNo(no);
		System.out.println(personVo);

		int count = phonebookService.exeRemove(personVo);

		String result = "{\"count\": " + count + "}";
		System.out.println(result);
		return result;
	}

	// 회원정보수정폼(1명 데이터가져오기)

	@GetMapping("/api/persons/modify")
	public PersonVo modifyform(@PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.modifyform()");

		
		
		
		return null;
	}

	// 회원정보 수정
	@PutMapping("/api/persons/modify")
	public JsonResult modify(@RequestBody PersonVo personVo, HttpServletRequest request) {
		System.out.println("PhonebookController.modify()");

		System.out.println(personVo);

		int no = JwtUtil.getNoFromHeader(request);
		if (no != -1) {// 정상
			// db에 수정시킨다
			phonebookService.exeModify(personVo);
			personVo.getName();
			return JsonResult.success(personVo.getName());

		} else {
			return JsonResult.fail("로그인하지 않음");
		}

	}

}
