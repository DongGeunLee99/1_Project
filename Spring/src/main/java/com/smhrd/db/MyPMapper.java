package com.smhrd.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.smhrd.model.MyPageDTO;

@Mapper
public interface MyPMapper {
    
    public void insertMyPage(MyPageDTO dto);
    public List<MyPageDTO> selectMyPageById(String id);

    public boolean deleteMyPage(MyPageDTO dto);
}
