package com.ict.erp.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.ict.erp.common.DBCon;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.dao.impl.TicketMovieDAOImpl;
import com.ict.erp.service.TicketMovieService;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieServiceImpl implements TicketMovieService {
	private TicketMovieDAO tmdao = new TicketMovieDAOImpl();
	@Override
	public List<TicketMovie> selectTicketMovieList(TicketMovie tm) throws SQLException {
		tmdao.setConnection(DBCon.getCon());
		try {
			return tmdao.selectTicketMovieList(tm);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public TicketMovie selectTicketMovie(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertTicketMovie(TicketMovie tm) throws SQLException {
		tmdao.setConnection(DBCon.getCon());
		try {
			return tmdao.insertTicketMovie(tm);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

	@Override
	public int updateTicketMovie(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTicketMovie(TicketMovie tm) throws SQLException {
		tmdao.setConnection(DBCon.getCon());
		try {
			tm = tmdao.selectTicketMovie(tm);
			String tmImg = tm.getTmImg();
			System.out.println(tmImg);
			return 0;
			//return tmdao.deleteTicketMovie(tm);
		}catch(SQLException e) {
			throw e;
		}finally {
			DBCon.close();
		}
	}

}
