package com.mybank.inter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CreatingProxyForObject implements InvocationHandler{
	private Object iObj;
	public  CreatingProxyForObject(Object anObjc)
	{
		iObj = anObjc;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy used " + method.getName() + " method.");
		  return method.invoke(iObj, args);
	}
}
