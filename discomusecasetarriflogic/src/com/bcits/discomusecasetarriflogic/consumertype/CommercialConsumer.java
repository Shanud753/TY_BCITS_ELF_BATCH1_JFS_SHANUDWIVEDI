package com.bcits.discomusecasetarriflogic.consumertype;

import java.util.Scanner;

public class CommercialConsumer {
	
	/*
	 * 1.0-1000 Units(Kwh) - 10Rs(PerUnit) 
	 * 2.1000-2000 Units(Kwh) - 15Rs(PerUnit) 
	 * 3. Above 2000 Units(Kwh) - 18Rs(PerUnit)
	 */
	
	public void tarrifCalForCommercial(double units) { 
		double	totAmount =0;
		if(units<1000) {
			totAmount = units*10;
			System.out.println("Your Total Bill is Rs: " + totAmount +"/-");
		} else if(units>=1000 && units<=2000) {
			totAmount = (1000*10)+(units-1000)*15;
			System.out.println("Your Total Bill is Rs: "+ totAmount +"/-");
		}else {
			totAmount = (1000*4)+(1000*5)+(units-2000)*18;
			System.out.println("Your Total Bill is Rs: "+ totAmount +"/-");
		}
			
		}
	
	
	}

