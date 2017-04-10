package Util;

import java.io.File;
import java.io.IOException;

public class practise {
	
	
	public static void main(String[] args){
		File file = new File("./src/main/webapp/dfgd");
		if (!file.exists()) {
			file.mkdirs();
		}
		
		File fil=new File(".");
		String path=file.getAbsolutePath();
		//path=fil.getPath();
		System.out.println(path);
		System.out.println("ok");
	}
}
