package com.ms.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ms.services.ConnFactory;
import com.ms.services.Department;

public class DepartmentDaoImpl implements DepartmentDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	private static Connection conn = cf.getConnection();

	public List<Department> getDepartmentList() throws SQLException {
		
	
        String sql = "SELECT * FROM DEPARTMENT";
        PreparedStatement stmt = conn.prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        
        List<Department> depList = new ArrayList<Department>();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        while (rs.next()) {
            Department d = new Department();
            d.setDep_id(rs.getInt("DEP_ID"));
            d.setDep_name(rs.getString("DEP_NAME"));
            depList.add(d);
        }
        for (int i=0; i<depList.size(); i++ ) {
        System.out.println(depList.get(i));
        }
        return depList;

    }

}
