package Utilities;

import java.io.File;
import java.util.Date;

public class sampleFolder {
	
	public static void main (String[] args) {
	
		Date date = new Date() ;
		String udate= date.toString().replaceAll(":", ".").replaceAll(" ", "_");
		System.out.println(udate);
		String reportFolder= System.getProperty("user.dir")+"\\testReport\\"+udate;
		String screenshotPath= reportFolder+"\\screenshots";
		System.out.println(screenshotPath);
		File file = new File(screenshotPath);
		file.mkdirs();
		
		
	}

}
