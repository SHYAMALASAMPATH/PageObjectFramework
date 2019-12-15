package com.rameshsoft.auto.supporters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class PropertiesUtilities {
	
	private String filePath;
	private FileInputStream fip;
	private Properties prop;
	private String value; 
	public PropertiesUtilities(String filePath) throws IOException {
	     //super();
		fip = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fip);
		this.filePath=filePath;
	}
	
	public String getPropertyValue(String key) {
		value=prop.getProperty(key);
		return  value;
	  }
	
	public String getPropertyValue(String key,String defaultValue) {
		 value = prop.getProperty(key, defaultValue);
		return value;
	  }
	
	public String getPropertyValue(Object key) {
			value=prop.getProperty((String) key);
			return  value;
		  }
	public String getPropertyValue(Object key,Object defaultValue) {
		value=(String) prop.getOrDefault(key, defaultValue);
		return  value;
	  }	
	
	 public Set<String> getAllKeys(){
		 
		Set<Object> key = prop.keySet();
		  Set<String> UniqKey = new HashSet();
		   for(Object obj : key) {
		      String keys = (String) obj;
		     	UniqKey.add(keys);
		}
		return UniqKey;
	  }
	
	public List<String> getAllkeyValue(){
		Set<String> keys = getAllKeys();
		List<String> allValues =new ArrayList<>();
		for(String obj:keys) {
			String value = prop.getProperty(obj);
			allValues.add(value);
		}
		return allValues;
	}
	
	/*public static void main(String[] args) throws IOException {
		
     PropertiesUtilities props = new PropertiesUtilities
    		    ("G:\\SELENIUM\\new selenium\\Framework7AM\\Application.properties");
		String op = props.getPropertyValue("Home_pwd");
		System.out.println(op);
		
	   List<String> str = props.getAllkeyValue();
		System.out.println(str);
		
		 Set<String> str1 = props.getAllKeys();
			System.out.println(str1);
	}*/
	 
	public static HashMap<String, String> getDataFromProperties(String filePath) {
		 
		HashMap<String,String> propData = new HashMap<String, String>();
		
		try {
			FileInputStream	fr = new FileInputStream(filePath);
			Properties props = new Properties();
			props.load(fr);	
			Set<Object> allProperties = props.keySet();
			for(Object key:allProperties){
				String keyvalue = props.getProperty(key.toString());
				
				propData.put(key.toString(), keyvalue);
				
			}
		}  catch (IOException e) {
			System.out.println("unable to read the property file."+propData);
			System.exit(0);
		}
		return propData;
	}

	
	
	

}
