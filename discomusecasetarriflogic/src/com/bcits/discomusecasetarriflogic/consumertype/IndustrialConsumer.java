package com.bcits.discomusecasetarriflogic.consumertype;

public class IndustrialConsumer {
	/*
	 * 1.0-10,000 Units(Kwh) - 15Rs(PerUnit) 
	 * 2.10,000-20,000 Units(Kwh) - 20Rs(PerUnit) 
	 * 3. Above 20,000 Units(Kwh) - 25Rs(PerUnit)
	 */
	
	public void tarrifCalForIndustry(double units) { 
		double	totAmount =0;
		if(units<10000) {
			totAmount = units*15;
			System.out.println("Your Total Bill is Rs: " + totAmount +"/-");
		} else if(units>=10000 && units<=20000) {
			totAmount = (10000*15)+(units-10000)*20;
			System.out.println("Your Total Bill is Rs: "+ totAmount +"/-");
		}else {
			totAmount = (10000*15)+(10000*20)+(units-20000)*25;
			System.out.println("Your Total Bill is Rs: "+ totAmount +"/-");
		}
			
		}
	
}
