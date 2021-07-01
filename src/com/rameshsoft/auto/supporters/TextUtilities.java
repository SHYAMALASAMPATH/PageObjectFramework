package com.rameshsoft.auto.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class TextUtilities {
	private String filePath;
	private static File file;
	private static FileWriter fileWriter;
	private static BufferedWriter bufferedWriter;
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;
	private static String data;
	
	public TextUtilities(String filePath) throws IOException {
		 file = new File(filePath);	
		 boolean status = file.createNewFile();
		 String val = (status)?"true":"false";
		 
		 fileWriter = new FileWriter(file);
		 bufferedWriter = new BufferedWriter(fileWriter);
		 fileReader = new FileReader(file);
		 bufferedReader = new BufferedReader(fileReader);	 
	}
	

	public String writeData(String data) throws IOException {
		Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
		if(op.isPresent()) {
			bufferedWriter.write(data);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
		}
		return data;
	}
	
	public char[] writeData(char[] data) throws IOException {
		Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
		if(op.isPresent()) {
			bufferedWriter.write(data);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
		}
		return data;
	}
	
	public String[] writeData(String[] data) throws IOException {
		Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
		if(op.isPresent()) {
			for(String str : data) {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				
			}
		}else {
			System.out.println("BW IS POINTING TO NULL");
		}
		return data;
	}
	
	public void writeData(int data) throws IOException {
		   Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
			     if(op.isPresent()) {
			    	 bufferedWriter.write(data);
			    	 bufferedWriter.newLine();
			    	 bufferedWriter.flush();
			    	 bufferedWriter.close();
	            }else {
	    			System.out.println("BW IS POINTING TO NULL");
	    		}
        }
	
	public void writeData(int[] data) throws IOException {
		Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
		if(op.isPresent()) {
			for(int str : data) {				
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				bufferedWriter.close();
			}
		}else {
			System.out.println("BW IS POINTING TO NULL");
		}
	}
	
	public List<String> writeData(List<String> data) throws IOException {
		Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
		if(op.isPresent()) {
			for(String obj : data) {
				bufferedWriter.write(obj);
				bufferedWriter.newLine();
			}
		}else {
			System.out.println("BW IS POINTING TO NULL");
		}
		bufferedWriter.flush();
		return data;
	}
	
	public Set<String> writeData(Set<String> data) throws IOException {
		Optional<BufferedWriter> op = Optional.ofNullable(bufferedWriter);
		if(op.isPresent()) {
			for(String obj : data) {
				bufferedWriter.write(obj);
				bufferedWriter.newLine();
			}
		}else {
			System.out.println("BW IS POINTING TO NULL");
		}
		bufferedWriter.flush();
		return data;
	}
	
	public String getData() throws IOException {
		data="";
		Optional<BufferedReader> op = Optional.ofNullable(bufferedReader);
		if(op.isPresent()) {
			 data = bufferedReader.readLine();
		}
		return data;
	}
	
	public List<String> getTotalData() throws IOException {
	     List<String> totalFileData = new ArrayList<String>();
			while(bufferedReader.ready()){
				totalFileData.add(bufferedReader.readLine());
			  }
			//System.out.println(totalFileData);
			return totalFileData;
	}
	
	public Set<String> getTotalDataUnique() throws IOException {
		List<String> data = getTotalData();
		Set<String> uniqueData = new LinkedHashSet<String>(data);
		//System.out.println(uniqueData);
		return uniqueData;
		
	}
	
	public Map<Integer,String> getSingleData() throws IOException{
		Map<Integer,String> mapData = new LinkedHashMap<Integer, String>();
		int count = 1;
		while(bufferedReader.ready()) {
			mapData.put(count, bufferedReader.readLine());
			count++;
		}
		return mapData;
	}
   
	public static void main(String[] args) throws IOException {
		
		TextUtilities t = new TextUtilities
				       ("G:\\SeleniumFrameWorks\\InterviewPrograms\\testData\\divya2.txt");
		/*ArrayList<String> a = new ArrayList<String>();
		a.add("hello");
		a.add("web");
		a.add("tagname");
		a.add("tagname");
		a.add("web");
		t.writeData(a);
		
		System.out.println(t.getTotalDataUnique());
		t.writeData(a);
		System.out.println(t.getTotalData());*/
		
		String str = t.getData();
		
		System.out.println(str);
		
		
		
		/*a.add("10");
		a.add("25");
		a.add("26");
		
		t.writeData(a);
	
		
		System.out.println(t.getTotalData().toString());
		//System.out.println(t.getTotalDataUnique().toString());
*/	}


	
}
