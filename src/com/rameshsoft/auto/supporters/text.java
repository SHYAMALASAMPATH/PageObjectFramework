package com.rameshsoft.auto.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class text {

	private static String filePath;
	private static File file;
	private static FileWriter fileWriter;
	private static BufferedWriter bufferedWriter;
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;
	
	     public text(String filePath) throws IOException {
		//"G:\\SELENIUM\\new selenium\\Framework7AMP\\Test123.txt"
		 file = new File(filePath);	
		 boolean status = file.createNewFile();
		 String val = (status)?"true":"false";
		 fileWriter = new FileWriter(file,true);
		 bufferedWriter = new BufferedWriter(fileWriter);
		 fileReader = new FileReader(file);
		 bufferedReader = new BufferedReader(fileReader);	 
		
	}
	   public void writeData(String data) throws IOException {
		Optional optional = Optional.ofNullable(bufferedWriter);
         if(optional.isPresent()) {
        	 bufferedWriter.write(data);
        	 bufferedWriter.flush();
         }
	}     
	public static void main(String[] args) throws IOException {
		text text = new text("G:\\SELENIUM\\new selenium\\Framework7AMP\\Test1.txt");
		
		text.writeData("selenium");
		text.writeData("selenium webdriver\n");

	}
	
}
