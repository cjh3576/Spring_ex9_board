package com.jh.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	//1. Spring에서 제공하는 FileCopyUtils 클래스의 Copy 메소드 사용
	//저장 경로, MultipartFile
	public String saveFile(String realPath,MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//a. 저장할 파일명을 생성
		//UUID 클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		originalName = originalName.substring(originalName.lastIndexOf("."));
		
		fileSystemName = fileSystemName + originalName;
		
		//저장
		file = new File(realPath, fileSystemName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileSystemName;
	}
	
	//2. java에서 제공하는 OutPutStream
	public String saveFile2(String realPath,MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//a. 저장할 파일명을 생성
		//UUID 클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		originalName = originalName.substring(originalName.lastIndexOf("."));
		
		fileSystemName = fileSystemName + originalName;
		//저장
		file = new File(realPath,fileSystemName);
		FileOutputStream fs = new FileOutputStream(file);
		fs.write(multipartFile.getBytes());
		
		return fileSystemName;
	}
	//3. MultipartFile 클래스의 transferTo 객체 이용
	public String saveFile3(String realPath,MultipartFile multipartFile) throws Exception{
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		//a. 저장할 파일명을 생성
		//UUID 클래스를 사용
		String fileSystemName = UUID.randomUUID().toString();
		String originalName = multipartFile.getOriginalFilename();
		originalName = originalName.substring(originalName.lastIndexOf("."));
		
		fileSystemName = fileSystemName + originalName;
		//저장
		file = new File(realPath, fileSystemName);
		multipartFile.transferTo(file);
		
		return fileSystemName;
	}
}
