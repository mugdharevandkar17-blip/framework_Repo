package com.comcast.crm.fileUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	public String getDatafromJsonFile(String key) throws IOException, org.json.simple.parser.ParseException {
		FileReader file=new FileReader("./configAppData/commondata2.json");
		JSONParser parser=new JSONParser();
		Object obj = parser.parse(file);
		
		JSONObject map=(JSONObject)obj;
	    String data=(String) map.get(key);
		return data;
	
		
	}

}
