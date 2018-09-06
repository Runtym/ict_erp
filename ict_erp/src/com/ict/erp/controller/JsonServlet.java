package com.ict.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ict.erp.service.DepartService;
import com.ict.erp.service.impl.DepartServiceImpl;
import com.ict.erp.vo.DepartInfo;

/**
 * Servlet implementation class JsonServlet
 */
@WebServlet(
		urlPatterns = "/json/*"
		)
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gs = new Gson();
	
	public static Type getMapType(Class keyType, Class valueType){
	    return TypeToken.getParameterized(HashMap.class, keyType, valueType).getType();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"),Map.class);
		System.out.println(pMap); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> departList = ds.getDepartInfoNonePageList(null);
			String resStr = gs.toJson(departList);
			pw.println(resStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
		Map<String,String> pMap = gs.fromJson(request.getParameter("param"),Map.class);
		System.out.println(pMap); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> departList = ds.getDepartInfoNonePageList(null);
			String resStr = gs.toJson(departList);
			pw.println(resStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("put");

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }
		Map<String,String> pMap = gs.fromJson(sb.toString(),Map.class);
		System.out.println(pMap); 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> departList = ds.getDepartInfoNonePageList(null);
			String resStr = gs.toJson(departList);
			pw.println(resStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("delete");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		DepartService ds = new DepartServiceImpl();
		try {
			List<DepartInfo> departList = ds.getDepartInfoNonePageList(null);
			String resStr = gs.toJson(departList);
			pw.println(resStr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String jsonStr = "우편번호|시도|시도영문|시군구|시군구영문|읍면|읍면영문|도로명코드|도로명|도로명영문|지하여부|건물번호본번|건물번호부번|건물관리번호|다량배달처명|시군구용건물명|법정동코드|법정동명|리명|행정동명|산여부|지번본번|읍면동일련번호|지번부번|구우편번호|우편번호일련번호";
		String[] columns = jsonStr.split("\\|");
		for(String column : columns) {
			System.out.println(column + ",");
		}
	}
	
}
