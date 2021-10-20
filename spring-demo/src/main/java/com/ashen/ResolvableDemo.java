package com.ashen;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;

/**
 * ResolvableType 通过反射获取目标类的信息
 */
public class ResolvableDemo {
	private HashMap<String, List<Integer>> customMap;

	// 获取 customMap 中的相关类型信息
	public static void main(String[] args) throws NoSuchFieldException {
		Field field = ResolvableDemo.class.getDeclaredField("customMap");
		ResolvableType resolvableType = ResolvableType.forField(field);
		// 获取泛型信息
		System.out.println(resolvableType.getGeneric(0).resolve());
		System.out.println(resolvableType.getGeneric(1).resolve());
		System.out.println(resolvableType.getGeneric(1));
		// 获取父类信息
		System.out.println(resolvableType.getSuperType());
		
		System.out.println(resolvableType.asMap());
		System.out.println(resolvableType.resolveGeneric(1, 0));
	}
}
