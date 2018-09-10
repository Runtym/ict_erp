package com.ict.erp.filer;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AuthFilter implements Filter {
	private Log log = LogFactory.getLog(this.getClass());
	
    public AuthFilter() {
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpSession hs = hsr.getSession();
		String uri = hsr.getRequestURI();
		
		//3. 인포
		log.info(hsr.getMethod() + ":" + hsr.getRequestURI());
		if(hs.getAttribute("user")==null && uri.indexOf("login")==-1) {
			// TODO 권한 처리 필요.(로그인 페이지 이동 로직 추가 필요)
			log.info("너 권한 없음");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
