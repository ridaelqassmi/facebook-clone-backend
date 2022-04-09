package com.facebook.facebookclone.CommunService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class CommenFunctions {
	public static String dir = System.getProperty("user.dir")+"\\src\\main\\java\\com\\facebook\\facebookclone\\images";
	public static byte[] hundleUpload(MultipartFile file) throws IOException{
		String fileName=Math.random()+"-"+file.getOriginalFilename().substring(file.getOriginalFilename().length()-4);
		Path DirAndFilePath = Paths.get(dir,fileName);
		Files.write(DirAndFilePath, file.getBytes());
		File f = new File(dir+"\\"+fileName);
		byte[] picInBytes = new byte[(int) f.length()];
		FileInputStream fileInputStream = new FileInputStream(f);
		fileInputStream.read(picInBytes);
		fileInputStream.close();
		f.delete();
		return picInBytes;
		
	}

}
