package com.smhrd.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyPageDTO {
    private String id;
    private List<Coordinate> polygon; // 폴리곤 좌표 리스트
    private String category;
    private String region;
    private String polygonWKT; // WKT 형식으로 변환된 폴리곤 데이터를 저장할 필드 추가
}
