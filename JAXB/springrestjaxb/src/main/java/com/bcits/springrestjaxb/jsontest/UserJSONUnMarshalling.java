package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;

public class UserJSONUnMarshalling {
  public static void main(String[] args) {
	//UnMarshalling from JSON to java object
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				UserInfoBean userInfoBean = objectMapper.readValue(new File("empJson8.json"), UserInfoBean.class);
				System.out.println(userInfoBean);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//End of main()
	}//End of Class

