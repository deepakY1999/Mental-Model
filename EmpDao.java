package com.Emp.Emp;

import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;

public class EmpDao {
	JdbcTemplate template;
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	

	
	

	public List<Emp> getEmployeesByPage(int pageid, int total) {
		// TODO Auto-generated method stub
		String sql="select*from emp limit"+(pageid-1)+","+total;
		return template.query(sql, new RowMapper<Emp>() {
			public Emp mapRow(ResultSet rs,int row)throws SQLException{
				Emp e=new Emp();
				e.setLearn_React(rs.getString(1));
				e.setLearn_Node(rs.getString(2));
				e.setLearn_JavaScript_Programming(rs.getString(3));
				return e;
			}
		});
	}





	public int save(Emp emp) {
		String sql="insert into Emp(Learn_Node,Learn_JavaScript_Programming)values emp.getLearn_Node()+" ;
		return template.update(sql);
	}





	private void values(String string) {
		// TODO Auto-generated method stub
		
	}





	public int update(Emp emp) {
		
		String sql="update Emp set name="+emp.getLearn_Node()+" "+emp.getLearn_JavaScript_Programming()+" "+"where_Id=emp.getId()";
		return template.update(sql);
	}





	public int delete( int id) {
		
		String sql="Delete from Emp where id="+id+"";
		return template.update(sql);
	}

}
