package ru.Bronetemkin.someunnamedwalker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
	public static boolean bRegExpFind(String inpStr, String regExPattern){
		Pattern p = Pattern.compile(regExPattern);
		Matcher m = p.matcher(inpStr);
		boolean mf = m.find();
		return mf;
	}
	
	public static Matcher readList(String inpStr, String regExPattern){
		Pattern p = Pattern.compile(regExPattern);
		Matcher m = p.matcher(inpStr);
		return m;
	}
}
