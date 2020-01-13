package com.bcits.jpawithhibernatepractice.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeAddressPK;
import com.bcits.jpawithhibernatepractice.onetoone.EmployeeSecondaryInfo;

public class InsertOneToMany {
	public static void main(String[] args) {
		
	
		EntityTransaction transaction = null;  
		EntityManager manager = null;
		EmployeePrimaryInfo demo = new EmployeePrimaryInfo();
		demo.setEid(15);
		demo.setEname("Manisha");
		demo.setMobile_no(8976543251l);
		demo.setOfficialMailid("manisha1@gmail.com");
		demo.setDob(java.sql.Date.valueOf("1998-12-14"));
		demo.setDoj(java.sql.Date.valueOf("2018-10-24"));
		demo.setDesignation("HR");
		demo.setBldGrp("b+");
		demo.setSalary(60000.0);
		demo.setDepId(40);
		demo.setMrgId(102);
		
		EmployeeAddressPK addressPK = new EmployeeAddressPK();
		addressPK.setEid(15);
		addressPK.setAddressType("permanent");
		
		EmployeeAddressInfo info = new EmployeeAddressInfo();
		info.setAddressPK(addressPK);
		info.setHouseNo(12);
		info.setAddress1("bulbul garden");
		info.setAddress2("gali no 8");
		info.setLandMark("axis bank atm");
        info.setCity("delhi");	
        info.setPinCode(876543);
        info.setPrimaryInfo(demo);
        

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 15);
//			info.setPrimaryInfo(pr);
//         	manager.persist(info);
			EmployeePrimaryInfo pr = manager.find(EmployeePrimaryInfo.class, 15);
			info.setPrimaryInfo(pr);
			System.out.println(pr.getAddress().get(0).getCity());
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
		}
}

