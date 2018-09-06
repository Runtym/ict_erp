package com.ict.erp.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Music{
	private String name;

	public Music() {
		System.out.println("나 호출했구나~");
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Music.class;
		Music music = (Music)clazz.newInstance();
		
		Method[] ms = clazz.getDeclaredMethods();
		for(Method m : ms) {
			String methName = m.getName();
			if(methName.indexOf("get")==0) {
				Method mm = clazz.getMethod("setName", String.class);
				mm.invoke(music, "마에스트로");
				System.out.println(m.invoke(music));
			}
		}
	}
}
