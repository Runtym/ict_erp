package com.ict.erp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ict.erp.common.DBCon;

import oracle.jdbc.OracleTypes;

public class CallProcedure {

	public static void main(String[] args) {
		String sql = "{call P_GET_EMP_CUR(?,?)}";
		Connection con = DBCon.getCon();
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, "KING");
			cs.registerOutParameter(2, OracleTypes.CURSOR);
			cs.executeQuery();
			ResultSet rs = (ResultSet)cs.getObject(2);
			while(rs.next()) {
				System.out.println(rs.getInt("empno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
