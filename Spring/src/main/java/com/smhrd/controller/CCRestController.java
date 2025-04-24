package com.smhrd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.db.CCMapper;
import com.smhrd.model.KakaoDTO;

@RestController
@CrossOrigin
public class CCRestController {
	
	
	@Autowired
	CCMapper mapper;
	
	@PostMapping("/login")
	public boolean login(@RequestBody KakaoDTO dto) { 
		System.out.println("inin");
		KakaoDTO existingDto = mapper.checkAcount(dto.getId());
        if (existingDto == null) {
            mapper.join(dto);
        }
        System.out.println("POST 요청 처리됨: id = " + dto.getId() + ", nickname = " + dto.getNickname());
        return true;
	}


}
