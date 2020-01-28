package com.bcits.discomusecasetarriflogic.consumertype;

public class ResidentialConsumer {

	/*
	 * 1.0-100 Units(Kwh) - 4Rs(PerUnit) 
	 * 2.100-200 Units(Kwh) - 5Rs(PerUnit) 
	 * 3. Above 200 Units(Kwh) - 8Rs(PerUnit)
	 */
	
	
	public void tarrifCalForResidential(double units) { 
	   double	totAmount =0;
		if(units<100) {
			totAmount = units*4;
			System.out.println("Your Total Bill is Rs: " + totAmount +"/-");
		} else if(units>=100 && units<=200) {
			totAmount = (100*4)+(units-100)*5;
			System.out.println("Your Total Bill is Rs: "+ totAmount +"/-");
		}else {
			totAmount = (100*4)+(100*5)+(units-200)*8;
			System.out.println("Your Total Bill is Rs: "+ totAmount +"/-");
		}
			
		}
}
