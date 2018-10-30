package kr.or.ddit.util;

import java.io.File;

public class StringUtil {
	public static String getFileNameFrimHeader(String ContentDisposition){

		int StringStart = ContentDisposition.indexOf("filename=");
		int StringEnd = ContentDisposition.lastIndexOf("\"");
		String fileName = ContentDisposition.substring(StringStart+10, StringEnd);
		// 파일쓰기
		// url 정보를 실제 파일경로로 변경
		
		return fileName;
		
	}

	public static String getCookie(String ContentDisposition, String string) {

		String cookieValue = "";
		
		String[] cookies = ContentDisposition.split("; ");
		for(int i = 0; i < cookies.length; i++){
			String str = cookies[i];
			if(str.startsWith(string +"=")){
				cookieValue = str.substring((string + "=").length());
			}
		}
		return cookieValue;
	}
	
}
