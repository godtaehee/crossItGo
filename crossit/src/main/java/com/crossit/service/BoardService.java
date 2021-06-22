package com.crossit.service;

import java.util.List;

import com.crossit.entity.Board;
import com.crossit.entity.FileVo;
import com.crossit.entity.IndexView;

public interface BoardService {

	public Board get(int i);
	
	public List<IndexView> getList();
	
	
	//글쓰기 구현
	public void boardWirte(Board board);
	
	//파일 업로드 메서드 추가
	int fileInsert(FileVo file);
	
	

}