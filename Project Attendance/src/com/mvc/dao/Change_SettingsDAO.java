package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.bean.Change_SettingsBean;
import com.mvc.util.DBConnection;

public class Change_SettingsDAO {

	Connection con = null;
	Statement stmt = null;
	int rs = -1;
	ResultSet r;

	public String validate(Change_SettingsBean change_SettingsBean) {
		String Eid=change_SettingsBean.getEid();
		String Password = change_SettingsBean.getPassword();
		String Newpassword = change_SettingsBean.getNewpassword();

		try {
			con = DBConnection.getConnection();
			String msg = "update MsitLogin set Password='" + Newpassword + "'where Eid='" + Eid
					+ "'and Password='" + Password + "'";
			stmt = con.createStatement();
			rs = stmt.executeUpdate(msg);

			if (rs > 0) {
				msg = "select Role from MsitLogin where Eid='" + Eid + "'";
				r = stmt.executeQuery(msg);

				while (r.next()) {
					String Role = r.getString("Role");
					return Role;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Invalid User Credentials.";

	}

}
