package com.bcits.employeedatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;

public interface EmployeeRepository extends CrudRepository<EmployeeInfoBean, Integer> {

	@Query("from EmployeeInfoBean where empId= :id and password= :pwd")
    public EmployeeInfoBean getEmployeeByIdAndPass(int id, @Param("pwd") String password);
	
	//@Query("SELECT * FROM Todo t WHERE t.title = 'title'")
	//@Query(" select * from employee_primary_info ev where e.empid='empId'")
}//End of Interface
