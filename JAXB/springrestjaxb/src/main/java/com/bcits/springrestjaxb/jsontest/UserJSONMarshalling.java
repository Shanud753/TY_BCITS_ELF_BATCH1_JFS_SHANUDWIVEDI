package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfo;

public class UserJSONMarshalling {
  
	public static void main(String[] args) {
		 UserInfoBean userInfoBean = new UserInfoBean();
			userInfoBean.setEmpId(1234);
			userInfoBean.setDeptId(22);
			userInfoBean.setDesignation("SSD");
			userInfoBean.setDob(new Date());
			userInfoBean.setDoj(new Date());
			userInfoBean.setEname("Shanu");
			userInfoBean.setBldGrp("AB+");
			userInfoBean.setMgrId(0);
			userInfoBean.setOfficialMailid("shanu@email.com");
			userInfoBean.setSalary(98765);
			userInfoBean.setMobileNo(9876543214l);
			userInfoBean.setPassword("qwerty");
			
			UserOtherInfo userOtherInfo = new UserOtherInfo();
			userOtherInfo.setGender("Female");
			userOtherInfo.setAadharNo(1234565679l);
			
			userInfoBean.setUserOtherInfo(userOtherInfo);
			
			UserAddressBean permanentAddressInfo = new UserAddressBean();
			permanentAddressInfo.setHouseNum(1);
			permanentAddressInfo.setStreet("Litle milenium");
			permanentAddressInfo.setCity("Delhi");
			permanentAddressInfo.setAddressType('p');
			
			UserAddressBean TempAddressInfo = new UserAddressBean();
			TempAddressInfo.setHouseNum(55);
			TempAddressInfo.setStreet("xyz Street");
			TempAddressInfo.setCity("Blr");
			TempAddressInfo.setAddressType('t');
			
			List<UserAddressBean> userAddressList = new ArrayList<UserAddressBean>();
			userAddressList.add(TempAddressInfo);
			userAddressList.add(permanentAddressInfo);
			
			userInfoBean.setUserAddressesList(userAddressList);
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.writerWithDefaultPrettyPrinter(); //Formatted JSON Object
				mapper.writeValue(new File("empJson8.json"), userInfoBean);
				mapper.writeValue(System.out, userInfoBean);
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
}
