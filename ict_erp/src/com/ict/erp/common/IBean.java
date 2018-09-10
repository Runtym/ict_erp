package com.ict.erp.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.BeanProcessor;

@SuppressWarnings("unchecked")
public class IBean {

	public static <E> List<E> convertList(ResultSet rs, Class<?> clazz) throws SQLException{
		ArrayList<E> list = new ArrayList<E>();
		BeanProcessor bp = new BeanProcessor();
		while(rs.next()) {
			list.add((E) bp.toBean(rs, clazz));
		}
		return list;
	}


	public static <E> E convert(ResultSet rs, Class<E> clazz) throws SQLException{
		BeanProcessor bp = new BeanProcessor();
		if(rs.next()) {
			return (E) bp.toBean(rs, clazz);
		}
		return null;
	}
	public static <E> E parseRequest(HttpServletRequest req, Class<?> clazz) throws Exception {
		E obj;
		try {
			obj = (E)clazz.newInstance();
			BeanUtils.populate(obj, req.getParameterMap());
			return obj;
		} catch (Exception e) {
			throw e;
		}
	}
	public static <E> E parseRequest(Map<String,String> req, Class<?> clazz) throws Exception {
		E obj;
		try {
			obj = (E)clazz.newInstance();
			BeanUtils.populate(obj, req);
			return obj;
		} catch (Exception e) {
			throw e;
		}
	}
}
