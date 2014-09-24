/**
 * @file		HeapUtil.java
 * @brief   Heap관련 유틸리티  
 * @author  개발1팀 / 파트1
 * @author  김연근 ( solaris@wemakeprice.com )
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-03-14
 */
package com.juseyo.commons.lib.utility;

import java.text.DecimalFormat;
import java.util.HashMap;

public class HeapUtil {

	public static void consolePrint ()  throws Exception {

		int mb = 1024*1024;
		DecimalFormat df = new DecimalFormat("#,##0");
		
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
          
        System.out.println("##### Heap utilization statistics #####");
          
        //Print used memory
        System.out.println("Used Memory : "
            + df.format((runtime.totalMemory() - runtime.freeMemory()) / mb) + " MByte ( " + df.format( runtime.totalMemory() - runtime.freeMemory() ) + " byte )" );
  
        //Print free memory
        System.out.println("Free Memory : "
            + df.format( runtime.freeMemory() / mb )+ " MByte ( " + df.format( runtime.freeMemory() ) + " byte )" );
          
        //Print total available memory
        System.out.println("Total Memory : " + df.format( runtime.totalMemory() / mb ) + " MByte ( " + df.format( runtime.totalMemory() ) + " byte )" );
  
        //Print Maximum available memory
        System.out.println("Max Memory : " + df.format( runtime.maxMemory() / mb ) + " MByte ( " + df.format( runtime.maxMemory() ) + " byte )" );

	}
	
	public static String getConsole()  throws Exception {

		int mb = 1024*1024;
		DecimalFormat df = new DecimalFormat("#,##0");
		
		StringBuffer buffer = new StringBuffer();
		
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
          
        buffer.append("##### Heap utilization statistics #####");
        buffer.append("\n");   
        //Print used memory
        buffer.append("Used Memory : "
            + df.format((runtime.totalMemory() - runtime.freeMemory()) / mb) + " MByte ( " + df.format( runtime.totalMemory() - runtime.freeMemory() ) + " byte )" );
        buffer.append("\n"); 
        //Print free memory
        buffer.append("Free Memory : "
            + df.format( runtime.freeMemory() / mb )+ " MByte ( " + df.format( runtime.freeMemory() ) + " byte )" );
        buffer.append("\n");   
        //Print total available memory
        buffer.append("Total Memory : " + df.format( runtime.totalMemory() / mb ) + " MByte ( " + df.format( runtime.totalMemory() ) + " byte )" );
        buffer.append("\n"); 
        //Print Maximum available memory
        buffer.append("Max Memory : " + df.format( runtime.maxMemory() / mb ) + " MByte ( " + df.format( runtime.maxMemory() ) + " byte )" );
        buffer.append("\n"); 
        return buffer.toString();
	}
	
	public static HashMap<String, Long> getHashMap()  throws Exception {
		
		Runtime runtime = Runtime.getRuntime();
		
		HashMap<String, Long> params = new HashMap<String, Long>();
		
		params.put( "Used", runtime.totalMemory() - runtime.freeMemory() );
		params.put( "Free", runtime.freeMemory() );
		params.put( "Total", runtime.totalMemory() );
		params.put( "Max", runtime.maxMemory() );
		
		return params;
		
	}
}
