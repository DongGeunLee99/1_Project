package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.db.MyPMapper;
import com.smhrd.model.Coordinate;
import com.smhrd.model.MyPageDTO;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MyPageController {

    @Autowired
    MyPMapper mapper;

    @PostMapping("/saveMyPage")
    public boolean saveMyPage(@RequestBody MyPageDTO dto) { 
        System.out.println("inin");

        // 폴리곤 좌표를 WKT 형식으로 변환
        StringBuilder polygonWKT = new StringBuilder("POLYGON((");
        for (Coordinate coordinate : dto.getPolygon()) {
            polygonWKT.append(coordinate.getLongitude())
                      .append(" ")
                      .append(coordinate.getLatitude())
                      .append(", ");
        }
        // 마지막 쉼표 제거
        polygonWKT.delete(polygonWKT.length() - 2, polygonWKT.length());
        polygonWKT.append("))");

        dto.setPolygonWKT(polygonWKT.toString());

        // DB 저장
        try {
            mapper.insertMyPage(dto);
            System.out.println("DB 저장 완료: id = " + dto.getId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    @PostMapping("/getMyPage")
    public List<MyPageDTO> getMyPage(@RequestBody MyPageDTO dto) {
    	System.out.println("output_inininin");
    	System.out.println(dto.getId());
        try {
        	System.out.println("try");
            // id에 해당하는 모든 행을 조회
            List<MyPageDTO> result = mapper.selectMyPageById(dto.getId());
            System.out.println(result);
            return result;
        } catch (Exception e) {
        	System.out.println("err");
            e.printStackTrace();
            return null;
        }
    }
    
    @PostMapping("/deleteInterest")
    public boolean deleteInterest(@RequestBody MyPageDTO dto) {
    	System.out.println("output_1");
        try {
            mapper.deleteMyPage(dto); // 삭제 로직
            System.out.println("output_2");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        	System.out.println("output_3");
            return false;
        }
    }


}
