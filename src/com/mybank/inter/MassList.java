package com.mybank.inter;

import java.util.ArrayList;
import java.util.List;

public class MassList extends ArrayList<Object> {
   public void AddSomeElements(Object[] obj)
   {
	   for(int i=0;i<obj.length;i++)
		   if((i+1)%2!=0)
		   super.add(obj[i]);
   }
}
