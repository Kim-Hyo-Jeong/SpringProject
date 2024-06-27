package com.example.myapp.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("repo")
public class HumanResourceRepository {

   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   public List<Employee> getEmpList() {
      String sql = 
         "SELECT " +
         "    employee_id, " +
         "    first_name, " +
         "    last_name, " +
         "    email, " +
         "    phone_number, " +
         "    hire_date, " +
         "    job_id, " +
         "    salary, " +
         "    commission_pct, " +
         "    manager_id, " +
         "    department_id " +
         "FROM " +
         "    employees ";
      
      return jdbcTemplate.query(sql, new RowMapper() {

         @Override
         public Object mapRow(ResultSet rs, int rowNum) throws SQLException { // callback
            Employee emp = new Employee();
            emp.setEmployee_id(rs.getInt("employee_id"));
            emp.setFirst_name(rs.getString("first_name"));
            emp.setLast_name(rs.getString("last_name"));
            emp.setEmail(rs.getString("email"));
            emp.setPhone_number(rs.getString("phone_number"));
            emp.setHire_date(rs.getDate("hire_date"));
            emp.setJob_id(rs.getString("job_id"));
            emp.setSalary(rs.getDouble("salary"));
            emp.setCommission_pct(rs.getDouble("commission_pct"));
            emp.setManager_id(rs.getInt("manager_id"));
            emp.setDepartment_id(rs.getInt("department_id"));
            return emp;
         }
      });
   }
   
   public int getEmpCount() {
	   String sql = "select count(*) from employees";
	   return jdbcTemplate.queryForObject(sql, Integer.class);
   }
   
   public int getEmpCount(int deptid) {
	   String sql = "SELECT COUNT(*) FROM employees WHERE department_id=?";
	   return jdbcTemplate.queryForObject(sql, Integer.class, deptid);
   }
   
}
