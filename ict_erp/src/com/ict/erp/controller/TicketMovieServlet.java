package com.ict.erp.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ict.erp.common.IBean;
import com.ict.erp.common.ICTUtils;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.service.impl.TicketMovieServiceImpl;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieServlet extends HttpServlet {
	private TicketMovieService ts = new TicketMovieServiceImpl();
	private Log log = LogFactory.getLog(this.getClass());
	private static final long serialVersionUID = 1L;
	private String uri;
	private static final int THRESHOLD_SIZE = 1024*1024*5;//5MB
	private static final int UP_TOTAL_SIZE = 1024*1024*100;//100MB
	private static final int UP_FILE_SIZE = 1024*1024*20;//20MB
	
	private static final File TEMP_REPOSITORY = new File(System.getProperty("java.io.tmpdir"));
	private static final String UP_PATH = "C:\\jsp_study\\workspace\\git\\ict_erp\\ict_erp\\WebContent";
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = "/views" + req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		
		try {
			if(cmd.equals("ticketMovieList")) {
				req.setAttribute("tmList", ts.selectTicketMovieList(null));
			}else if(cmd.equals("ticketMovieDelete")) {
				TicketMovie tm = IBean.parseRequest(req, TicketMovie.class);
				ts.deleteTicketMovie(tm);
				System.out.println(tm);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		doService(req,res);
	}

	public static Map<String,String> parseRequest(HttpServletRequest req) throws Exception{
		Map<String,Object> rMap = new HashMap<String,Object>();
		if(!ServletFileUpload.isMultipartContent(req)) {
			throw new ServletException("폼 인크립트가 파일업로드에 적합하지 않습니다.");
		}
		DiskFileItemFactory dfFactory = new DiskFileItemFactory(THRESHOLD_SIZE, TEMP_REPOSITORY);
		
		ServletFileUpload sfu = new ServletFileUpload(dfFactory);
		sfu.setHeaderEncoding("utf-8");
		sfu.setSizeMax(UP_TOTAL_SIZE);
		sfu.setFileSizeMax(UP_FILE_SIZE);
		List<FileItem> fList = sfu.parseRequest(req);
		Map<String,String> params = new HashMap<String,String>();
		for(FileItem fi:fList) {
			if(fi.isFormField()) {
				params.put(fi.getFieldName(), fi.getString("utf-8"));
			}else {
				String fName = File.separator + "upload" + File.separator + System.currentTimeMillis() + fi.getName().substring(fi.getName().lastIndexOf("."));
				params.put(fi.getFieldName(), fName);
				fi.write(new File(UP_PATH + File.separator + fName));
			}
		}
		return params;
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		uri = "/views" + req.getRequestURI();
		String cmd = ICTUtils.getCmd(uri);
		try {
			if(cmd.equals("ticketMovieInsert")) {
				Map<String,String> params = parseRequest(req);
				TicketMovie tm = IBean.parseRequest(params, TicketMovie.class);
				int cnt = ts.insertTicketMovie(tm);
				req.setAttribute("cnt", cnt);
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
		doService(req, res);
	}
	
	private void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher(uri);
		rd.forward(req, res);
	}

}
