package com.jh.board.qna;

import java.util.ArrayList;

import com.jh.board.BoardDTO;
import com.jh.file.FileDTO;

public class QnaDTO extends BoardDTO{
	private int ref;
	private int step;
	private int depth;
	//전체글의 갯수를 담을 변수 추가!
	private ArrayList<FileDTO> files;
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public ArrayList<FileDTO> getFiles() {
		return files;
	}
	public void setFiles(ArrayList<FileDTO> files) {
		this.files = files;
	}
	
	
	
}
