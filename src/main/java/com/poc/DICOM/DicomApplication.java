package com.poc.DICOM;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.controller.ImageController;
import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.model.Study;
import com.poc.util.Util;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })

public class DicomApplication {
	
	
	private void saveTODB(String key, Map<String, List<String>> valueMap, String category) {
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		SpringApplication.run(DicomApplication.class, args);
		System.out.println("spring eterte main started");

		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("\\D:\\DICOM\\DICOM\\src\\main\\resources\\json\\DICOM.json")) {
			String fileLocation = "D:\\DICOM\\DICOM\\src\\main\\resources\\json\\DICOM.json";
			
			System.out.println(fileLocation);

		
			String file = convertFileIntoString(fileLocation);
			System.out.println(file);
			
			Map<String, Object> map = jsonrtoMap(file);
			
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext()) {
				String key = it.next();
				Object value = map.get(key);
				
				//siva start
				if("00080021".equalsIgnoreCase(key) || "0020000E".equalsIgnoreCase(key) ) {
					
					Map valueMap = ((LinkedHashMap<String, ArrayList<String>>)value);
					
					List<Series> list=Util.seriesList(key,valueMap.get("vr").toString(),valueMap.get("Value").toString());
					
					ImageController ic=new ImageController();
					ic.createImage(list);
					System.out.println(list);
				}
				else if("00080018".equalsIgnoreCase(key) || "00200032".equalsIgnoreCase(key) ) {
					
					Map valueMap = ((LinkedHashMap<String, ArrayList<String>>)value);
					List<Image> list=Util.imageList(key,valueMap.get("vr").toString(),valueMap.get("Value").toString());
					System.out.println(list);
					
				}
				else{
					
					Map valueMap = ((LinkedHashMap<String, ArrayList<String>>)value);
					List<Study> list=Util.studyList(key,valueMap.get("vr").toString(),valueMap.get("Value").toString());
					System.out.println(list);
				}
				//sive end
				
				System.out.println("Key:"+key);
				Map valueMap = ((LinkedHashMap<String, ArrayList<String>>)value);
				System.out.println("vr:"+valueMap.get("vr"));
				System.out.println("value:"+valueMap.get("Value"));
				System.out.println("Category: "+Util.getCategrryMap(key));
			}
			
			
			

			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static List<Object> toList(JSONArray array) {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < ((CharSequence) array).length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof JSONObject) {
	            //value = toMap((JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}

	public static String convertFileIntoString(String file) throws Exception {

		
		String result;
		result = new String(Files.readAllBytes(Paths.get(file)));
		System.out.println("resultL::::::"+jsonrtoMap(result).toString());
		
		return result;

	}
	
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	  public static Map<String,Object> jsonrtoMap(String s )  {

	 
	 Map<String,Object> map1=new HashMap<String,Object>();
	try {
		TypeReference<HashMap<String, Object>> tyypeRef = new TypeReference<HashMap<String,Object>>() {};
	  map1=objectMapper.readValue(s, tyypeRef);
	  System.out.println(map1);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	  
	 return map1;
	  
	  }
	 
}
