package com.bcits.discomusecasetarriflogic.loginvalidation;

import java.util.Scanner;

import com.bcits.discomusecasetarriflogic.consumertype.CommercialConsumer;
import com.bcits.discomusecasetarriflogic.consumertype.IndustrialConsumer;
import com.bcits.discomusecasetarriflogic.consumertype.ResidentialConsumer;

public class EmployeeLoginValidation {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User-Name :");
		String name = scanner.next();
		System.out.println("Enter your Password :");
		String password = scanner.next();
		scanner.nextLine();
		
		//Validation For User
		if(name.equalsIgnoreCase("Shanu753") && password.equals("qwerty1")) {
			System.out.println("*******WELCOME TO DISCOM********");
			System.out.println("Please Enter Your Choice..."); 
			System.out.println("1. Generate Bill"); 
			System.out.println("2. Consumer Details"); 
			System.out.println("3. Logout");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:System.out.println("Please Enter the amount of Units Consumed");
			        int units = scanner.nextInt();
			        if((units<=100) || (units==100) || (units<=200) ||(units<=900)) {
			        	ResidentialConsumer residentialConsumer = new ResidentialConsumer();
			    		residentialConsumer.tarrifCalForResidential(units);
			        }else if((units<=1000) || (units<=2000) || (units<=9000) ) {
			        	CommercialConsumer commercialConsumer = new CommercialConsumer();
			        	commercialConsumer.tarrifCalForCommercial(units);
			        }else if((units<=10000) || (units<=20000) || (units<=90000)) {
			        	IndustrialConsumer industrialConsumer = new IndustrialConsumer();
			        	industrialConsumer.tarrifCalForIndustry(units);
			        }
			        
			        System.out.println("Please Enter Your Choice..."); 
					System.out.println("1. Generate Bill"); 
					System.out.println("2. Consumer Details"); 
					System.out.println("3. Logout");
					int choice1 = scanner.nextInt();
				break;
           
			case 2: System.out.println("Name : "+ name);
			        long num = 9876543212l;
			        System.out.println("Your Phone Number : "+ num);
			        System.out.println("Your Last Month Bill Payment Status : Yes "  );
			        
			        System.out.println("Please Enter Your Choice..."); 
					System.out.println("1. Generate Bill"); 
					System.out.println("2. Consumer Details"); 
					System.out.println("3. Logout");
			   break;
			   
			case 3: System.out.println("Thanks For Visiting!!");
				break;
			}
		}
		
		
		else {
			
			System.err.println("Please Enter Valid Credentials!!!");
			
		}
	}//End of main()
}//End of Class
