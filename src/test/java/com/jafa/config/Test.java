package com.jafa.config;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	
	@org.junit.Test
	public void test00() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		String formDate = sdf.format(date);
		System.out.println(formDate);
		String test = formDate.replace("-", File.separator);
		System.out.println(test);
	}
	
	@org.junit.Test
	public void Test00(){
		String contentType = "image...";
		System.out.println(contentType.startsWith("Image"));
	}
}
