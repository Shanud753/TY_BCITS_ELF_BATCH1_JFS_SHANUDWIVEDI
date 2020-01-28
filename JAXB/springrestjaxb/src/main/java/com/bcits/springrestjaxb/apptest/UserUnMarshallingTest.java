package com.bcits.springrestjaxb.apptest;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserUnMarshallingTest {
	public static void main(String[] args) {

		JAXBContext jaxbContext;
		try {
			jaxbContext =  JAXBContext.newInstance(UserInfoBean.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			UserInfoBean userInfoBean =(UserInfoBean) unmarshaller.unmarshal(new File("userInfo1.xml"));

			System.out.println("Emp Id   : "+ userInfoBean.getEmpId());
			System.out.println("Emp Name : "+ userInfoBean.getEname());
			System.out.println("Salary   : "+ userInfoBean.getSalary());
			System.out.println("DOB      : "+ userInfoBean.getDob());
			System.out.println("Gender   : "+ userInfoBean.getUserOtherInfo().getGender());
			System.out.println("Aadhar   : "+ userInfoBean.getUserOtherInfo().getAadharNo());
			
			
			for (UserAddressBean bean : userInfoBean.getUserAddressesList()) {
				System.out.println("Address Type  :"+ bean.getAddressType());
				System.out.println("City          :"+ bean.getCity());
				System.out.println("House Num     : "+ bean.getHouseNum());
				System.out.println("Street        :"+ bean.getStreet());
				System.out.println("*****************");
			}
			
		}catch (JAXBException e) {
			e.printStackTrace();
		}
	}//End of main()
}//End of Class
