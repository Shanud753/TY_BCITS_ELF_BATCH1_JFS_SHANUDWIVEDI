package com.ty.bcits.AlgorithmAnalysis;

import java.time.Duration;
import java.time.Instant;

public class AlgorithmAnalysis
{
	
   public static Long AddUpto(Long number)
   {
	   Long total=0L;
	   for(Long i=0L;i<=number;i++)
	   {
		   total=total+i;
	   }
	   return total;
   }
   
   public static Long AddUptoQuick(Long number)
   {
	   return number*(number+1)/2;
   }
   
   public static void countDurationAddUpto()
   {
	   Long number=999999999L;
	   Instant start=Instant.now();
	   System.out.println(AddUpto(number));
	   Instant end=Instant.now();
	   Long duration=Duration.between(start, end).toMillis();
	   double seconds=duration/1000.0;
	   System.out.println("AddUpto took "+seconds+"seconds");   
   }
   
   public static void countDurationAddUptoQuick()
   {
	   Long number=999999999L;
	   Instant start=Instant.now();
	   System.out.println(AddUptoQuick(number));
	   Instant end=Instant.now();
	   Long duration=Duration.between(start, end).toMillis();
	   double seconds=duration/1000.0;
	   System.out.println("AddUptoQuick took "+seconds+"seconds");   
   }
   
   public static void main(String[] args) {
	
	   countDurationAddUptoQuick();
	   countDurationAddUpto();
}
}
