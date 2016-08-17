package com.xyz.common.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateTest {

	
	public static void main(String[] args)
	{
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("name", "john");
		map.put("john", "clement");
		TemplateTest tempTest = new TemplateTest();
		tempTest.eval(map, "Hello ${name} how are you ${${name}}");
	}
	
	public void eval(Map<String,String> map,String patternString)
	{
		
		for(String s:map.keySet())
		{
			Pattern patt = Pattern.compile("\\$\\{"+s+"\\}");
			  Matcher m = patt.matcher(patternString);
			  StringBuffer sb = new StringBuffer(patternString.length());
			  while (m.find()) {
				  
			    String text = m.replaceAll(map.get(s));
			    
			    // ... possibly process 'text' ...
System.out.println(text);
patternString = text;
			  }
			 
		}
	}
	
}
