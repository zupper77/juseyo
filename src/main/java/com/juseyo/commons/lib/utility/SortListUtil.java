/**
 * @file	SortListUtil.java
 * @brief   간단한 설명 
 * @author  개발3/파트2
 * @author  김한주
 * @date    생성 : 2014. 4. 29.
 * @date    최종수정: 2014. 4. 29.
 */
package com.juseyo.commons.lib.utility;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @brief 	SortListUtil
 * @author 	개발3팀/파트2/김한주
 * @version 1.0
 * @date    생성: 2014. 4. 29.
 * @date    최종수정: 2014. 4. 29.
 * @remark	
 */
public class SortListUtil<T> implements Comparable<T>
{
	private List<T> list = null;
	private String key = null;		// 정렬기준이 되는 method명
	private int order = 1;			// 정렬순서 : 1 : asc, -1 : desc

	public void setSortKey(String key)
	{
		this.key = key;
	}
	public void setOrder(int order)
	{
		this.order = order;
	}
	public void setList(List<T> list)
	{
		this.list = list;
	}

	public int compareTo(T o)
	{
		compare(o);
		return 0;
	}

	private int compare(T o)
	{
		if (key == null)
			return 0;
		if (list == null)
			return 0;
		int size = list.size();
		if ((size <= 0) || (size > 1000))
			return 0;
		
		try
		{
			Class<?> c = o.getClass();
			final Method m = c.getMethod(key, (Class[])null);

			Comparator<T> comparator = new Comparator<T>()
			{
				public int compare(T o1, T o2)
				{
				    int result = 0;
				    try{
				        if(m.invoke(o1) instanceof Integer){
                            long a = Long.parseLong(m.invoke(o1) + "");
                            long b = Long.parseLong(m.invoke(o2) + "");

                            if (a > b)
                                result = 1 * order;
                            else if (a < b)
                                result = -1 * order;
				        }else{
	                        String a = (String) m.invoke(o1);
	                        String b = (String) m.invoke(o2);
	                        result = a.compareTo(b);
	                    }
				    }catch (Exception e) { }
                    return result;
				}
			};

			Collections.sort(list, comparator);
		}
		catch (Exception e) { }
		return 0;
	}

	public List<T> sort()
	{
		if (list.size() > 0)
		{
			T o = list.get(0);
			compare(o);
		}
		return list;
	}
}