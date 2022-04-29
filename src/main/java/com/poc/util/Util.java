package com.poc.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.model.Image;
import com.poc.model.Series;
import com.poc.model.Study;

public class Util {
	private static Map<String,String> map=new HashMap<String,String>();
	public static void initCategories(){
		System.out.println("categeoryMap()");
		map.put("00080018", "Image");
		map.put("00200032", "Image");
		map.put("00080021", "Series");
		map.put("0020000E", "Series");
		map.put("00080005", "Study");
		map.put("00080008", "Study");
		map.put("00080020", "Study");
		map.put("0020000D", "Study");
	
		
	}
	
	
	public static String getCategrryMap(String key){
		
		return map.get(key);
	}
	  
	  
	
	static {
		initCategories();
		
	}
	
	public static List<Series> seriesList(String id,String vr,String value){
		
		ArrayList al=new ArrayList();
		al.add(id);
		al.add(vr);
		al.add(value);
		
		return al;
		
	}
	
public static List<Image> imageList(String id,String vr,String value){
		
		ArrayList al=new ArrayList();
		al.add(id);
		al.add(vr);
		al.add(value);
		
		return al;
		
	}
	

public static List<Study> studyList(String id,String vr,String value){
	
	ArrayList al=new ArrayList();
	al.add(id);
	al.add(vr);
	al.add(value);
	System.out.println(al);
	
	return al;
	
}

}
