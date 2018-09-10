package com.ict.erp.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ict.erp.common.IBean;
import com.ict.erp.common.ICTUtils;
import com.ict.erp.dao.TicketMovieDAO;
import com.ict.erp.vo.MenuInfo;
import com.ict.erp.vo.TicketMovie;

public class TicketMovieDAOImpl extends CommonDAOImpl implements TicketMovieDAO {

	@Override
	public List<TicketMovie> selectTicketMovieList(TicketMovie tm) throws SQLException {
		String sql = "select * from ticket_movie";
		List<TicketMovie> tmList = new ArrayList<TicketMovie>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return ICTUtils.parseList(rs, TicketMovie.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public TicketMovie selectTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "select * from ticket_movie where tmNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tm.getTmNum());
			rs = ps.executeQuery();
			return IBean.convert(rs, TicketMovie.class);
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int insertTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "insert into ticket_movie(tmNum, tmName, tmPrice, "
				+ "tmStartdat, \r\n" + 
				"tmEnddat, tmCredat, tmDesc,tmImg)\r\n" + 
				"values(seq_tmNum.nextval,?,?,?,?,"
				+ "to_char(sysdate,'YYYYMMDD'),?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tm.getTmName());
			ps.setInt(2, tm.getTmPrice());
			ps.setString(3, tm.getTmStartdat().replace("-", ""));
			ps.setString(4, tm.getTmEnddat().replace("-", ""));
			ps.setString(5, tm.getTmDesc());
			ps.setString(6, tm.getTmImg());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int updateTicketMovie(TicketMovie tm) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTicketMovie(TicketMovie tm) throws SQLException {
		String sql = "delete from ticket_movie where tmNum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tm.getTmNum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

}
