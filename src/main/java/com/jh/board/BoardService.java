package com.jh.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.jh.util.PageMaker;

public interface BoardService {
	//글 추가
	public int setWrite(BoardDTO boardDTO,List<MultipartFile> multipartFiles, HttpSession session) throws Exception;
	
	//리스트
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception;
	
	//글 하나
	public BoardDTO getSelect(int num)throws Exception;

	//삭제
	public int setDelete(int num) throws Exception;
	
	//업뎃
	public int setUpdate (BoardDTO boardDTO) throws Exception;
}
