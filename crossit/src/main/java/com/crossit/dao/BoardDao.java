package com.crossit.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.crossit.entity.Board;
import com.crossit.entity.FileVo;
import com.crossit.entity.IndexView;


@Mapper
public interface BoardDao {

	//글의 목록을 조회
	//글을 등록, 수정, 삭제
	
	List<IndexView> getList();

	Board get(int id); 
	
	int update(Board board);
	int insert(Map articleMap);
	int delete(int id);

	
	
	//파일 업로드 메서드 
	int fileInsert(FileVo file);
	
	

}

	
