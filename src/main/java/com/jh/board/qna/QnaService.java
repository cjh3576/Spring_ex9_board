package com.jh.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.board.BoardDTO;
import com.jh.board.BoardService;
import com.jh.file.FileDAO;
import com.jh.file.FileDTO;
import com.jh.util.FileSaver;
import com.jh.util.PageMaker;

@Service
public class QnaService implements BoardService{
	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		//qna Insert
		int result = qnaDAO.setWrite(boardDTO);
		String realPath = session.getServletContext().getRealPath("/resources/qna");
		//files Insert
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		for(MultipartFile file: multipartFiles) {
			if(file.getOriginalFilename().length()>0) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setOname(file.getOriginalFilename());
				fileDTO.setFname(fileSaver.saveFile(realPath, file));
				files.add(fileDTO);
			}
		}
		result = fileDAO.setWrite(files);
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		//1. startRow,lastrow
		pageMaker.makeRow();
		List<BoardDTO> list =  qnaDAO.getList(pageMaker);
		//2. paging, totalCount
		int totalCount = qnaDAO.getTotalCount(pageMaker);
		pageMaker.makePage(totalCount);
		return list;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return qnaDAO.getSelect(num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		return qnaDAO.setDelete(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	//답글
	public int setReply(QnaDTO qnaDTO) throws Exception{
		//1. 사전작업
		int result = qnaDAO.setReplyUpdate(qnaDTO);
		//2. insert
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}

}
