package com.TextEditor.personal.Language.ForHtml;

public class OpenWithChrome {
	public static void V37(String File){
		  try{ 
			  Runtime.getRuntime().exec(".\\Debug\\Html\\Chrome\\chrome37.exe \""+File+"\""); 
			  } 
			  catch(Exception e) 
			  { 
			  } 
	}
}
