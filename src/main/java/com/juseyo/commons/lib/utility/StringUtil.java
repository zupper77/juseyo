/**
 * @file	StringUtil.java
 * @brief   StringUtil
 * @author  개발3/파트2
 * @author  김한주
 * @date    생성 : 2014. 5. 20.
 * @date    최종수정: 2014. 5. 20.
 */
package com.juseyo.commons.lib.utility;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Vector;
import java.util.StringTokenizer;
/**
 * @brief 	StringUtil
 * @author 	개발3팀/파트2/김한주
 * @version 1.0
 * @date    생성: 2014. 5. 20.
 * @date    최종수정: 2014. 5. 20.
 * @remark	
 */
public class StringUtil {
    
    /**
     * 문자열을 null검사를 하여 만약 null일 경우 빈문자열을 반환한다.
     * 예) String str1 = null;
     *       StringUtil.nvl(str1);
     * @author Evan
     * @param String value : 검사할 문자열.
     * @return String : value가 null이면 빈문자열을 반환하고 아니면 value값을 반환한다.
     */
    public static String nvl(String value){
        return nvl(value, "");
    }
    
    /**
     * 문자열을 null검사를 하여 만약 null일 경우 원하는 문자열을 반환한다.
     * 예) String str1 = "";
     *       StringUtil.nvl(str1, "Y");
     * @author Evan
     * @param String value : 검사할 문자열.
     * @param String mov : null 일경우 반환할 문자
     * @return String : value가 null이면 mov로 반환하고 아니면 value값을 반환한다.
     */
    public static String nvl(String value, String mov){
        if (value == null){
            return mov;
        }
            
        return value;
    }
    
    /**
     * 문자열을 null 또는 빈문자열 검사를 하여 만약 null이거나 빈문자열일 경우 원하는 문자열을 반환한다.
     * 예) String str1 = "";
     *       StringUtil.nvlNequal(str1, "Y");
     * @author Evan
     * @param String value : 검사할 문자열.
     * @param String mov : null 또는 빈문자열일 경우 반환할 문자열
     * @return String : value가 null 또는 빈문자열이면 mov로 반환하고 아니면 value값을 반환한다.
     */
    public static String nvlNequal(String value, String mov){
        if (value == null || value.equals("")){
            return mov;
        }
            
        return value;
    }
    
    /**
     * 문자열을 날짜형식으로 변환한다.
     * 예) StringUtil.getDisplayDate("20131121"); => "2013-11-21"
     * [주의]
     * 1. 날짜 문자열이 null이면 빈문자열로 반환한다.
     * 2. 날짜 문자열이 6자리 미만이면 오른쪽에 0을 채워서 변환해준다. (StringUtil.getDisplayDate("2013", "-"); => "2013-00")
     *     반대로 8자리 이상이면 8자리까지 절삭하여 반환한다. (StringUtil.getDisplayDate("20131121123"); => "2013-11-21")
     * 3. 문자열이 숫자인지는 검사를 하지 않는다. (StringUtil.getDisplayDate("ABCDEFGH"); => "ABCD-EF-GH")
     * 4. 날짜형식으로 변환된 값이 다시 들어올 경우 마스크를 제거한 후 다시 변환해 준다. (StringUtil.getDisplayDate("2013/11/21"); => "2013-11-21")
     * @author Evan
     * @param String date : "YYYYMMDD" 문자열
     * @return String : 날짜형식(YYYY-MM-DD)이나 날짜형식(YYYY/MM/DD)  변환된 문자열
     */
    public static String getDisplayDate(String date){   
        return getDisplayDate(date, "-");
    }

    public static String getDisplayDate2(String date){
        return getDisplayDate(date, "/");
    }
    
    /**
     * 문자열을 날짜형식으로 변환한다.
     * 예) StringUtil.getDisplayDate("20131121", "-"); => "2013-11-21"
     *       StringUtil.getDisplayDate("201311", "-"); => "2013-11"
     * [주의]
     * 1. 날짜 문자열이 null이면 빈문자열로 반환한다.
     * 2. 날짜 문자열이 6자리 미만이면 오른쪽에 0을 채워서 변환해준다. (StringUtil.getDisplayDate("2013", "-"); => "2013-00")
     *     반대로 8자리 이상이면 8자리까지 절삭하여 반환한다. (StringUtil.getDisplayDate("20131121123"); => "2013-11-21")
     * 3. 문자열이 숫자인지는 검사를 하지 않는다. (StringUtil.getDisplayDate("ABCDEFGH"); => "ABCD-EF-GH")
     * 4. 날짜형식으로 변환된 값이 다시 들어올 경우 마스크를 제거한 후 다시 변환해 준다. (StringUtil.getDisplayDate("2013/11/21"); => "2013-11-21")
     * 5. mask가 null이면 빈문자열로 바꿔서 넣어주기 때문에 변환하여도 입력한 그대로 반환된다.
     * @author Evan
     * @param String date : "YYYYMMDD" 문자열
     * @param String mask : 사용하려는 MASK 문자
     * @return String : 날짜형식(YYYY-MM-DD)이나 날짜형식(YYYY/MM/DD)  변환된 문자열
     */
    public static String getDisplayDate(String date, String mask){
        String str = "";
        mask = nvl(mask);
        
        if (date == null || date.equals("")) return "";
        
        try{
            date = unMask(date);
            int size = date.length();
            
            if (size <= 6){
                date = stringPadding(date, "RIGHT", "0", 6);
                str = date.substring(0, 4)+ mask + date.substring(4, 6);
            }
            else{
                date = stringPadding(date, "RIGHT", "0", 8);    
                str = date.substring(0, 4)+ mask + date.substring(4, 6) + mask + date.substring(6, 8);
            }
            
        }
        catch (Exception e){
            return date;
        }
        
        return str;
    }
    
    /**
     * 문자열을 시간형식으로 변환한다. 마스크를 설정한다. 4자리이하는 4자리로 변경후 변화  "1200" -> "12:00"
     * 예) StringUtil.getDisplayTime("122710"); => "12:27:10"
     *       StringUtil.getDisplayTime("1227");  => "12:27"
     * [주의]
     * 1. 시간 문자열이 null이면 빈문자열로 반환한다.
     * 2. 시간 문자열이 4자리 미만이면 오른쪽에 0을 채워서 변환해준다. (StringUtil.getDisplayTime("12"); => "12:00")
     *     반대로 6자리 이상이면 6자리까지 절삭하여 반환한다. (StringUtil.getDisplayTime("122710123"); => "12:27:10")
     * 3. 문자열이 숫자인지는 검사를 하지 않는다. (StringUtil.getDisplayTime("ABCDEF"); => "AB:CD:EF")
     * 4. 시간형식으로 변환된 값이 다시 들어올 경우 마스크를 제거한 후 다시 변환해 준다. (StringUtil.getDisplayTime("12:27:10"); => "12:27:10")
     * @author Evan
     * @param String time : "HH24MISS" 문자열
     * @return String : 시간형식("HH:24MI:SS") 으로 변환된 문자열
     */
    public static String getDisplayTime(String time){
        String str = "";
        
        if (time == null || time.equals("")) return "";
            
        try{
            time = unMask(time);
            int size = time.length();
            
            if (size <= 4){
                time = stringPadding(time, "RIGHT", "0", 4);
                str = time.substring(0, 2) + ":" + time.substring(2, 4);
            }
            else{
                time = stringPadding(time, "RIGHT", "0", 6);
                str = time.substring(0, 2) + ":" + time.substring(2, 4) + ":" + time.substring(4, 6);
            }
        }
        catch(Exception e){
            return time;
        }
        
        return str;
    }
    
    /**
     * 문자열을 날짜시간형식으로 변환한다
     * 예) StringUtil.getDisplayLongDate("20131121122710"); => "2013-11-21 12:27:10"
     * [주의]
     * 1. 날짜문자열이 null이면 빈문자열로 반환한다.
     * 2. mask가 null이면 빈문자열로 바꿔서 넣어주기 때문에 날짜는 변환하여도 입력한 그대로 반환된다. 하지만 시간은 자동으로 :이 붙는다.
     * 3. 날짜 문자열이 14자리 미만이면 오른쪽에 0을 채워서 변환해준다. (StringUtil.getDisplayLongDate("20131121", "-"); => "2013-11-21 00:00:00")
     *     반대로 14자리 이상이면 14자리까지 절삭하여 반환한다. (StringUtil.getDisplayLongDate("20131121122710123", "-"); => "2013-11-25 12:27:10")
     * 4. 문자열이 숫자인지는 검사를 하지 않는다. (StringUtil.getDisplayLongDate("ABCDEFGHIJKLMN"); => "ABCD-EF-GH IJ:KL:MN")
     * 5. 날짜형식으로 변환된 값이 다시 들어올 경우 마스크를 제거한 후 다시 변환해 준다. (StringUtil.getDisplayLongDate("2013/11/21 12:27:10", "-"); => "2013-11-21 12:27:10")
     * @author Evan
     * @param String datetm : "YYYYMMDDHH24MISS" 문자열
     * @param String mask : Mask 문자열
     * @return String : 날짜시간형식(YYYY-MM-DD HH:24MI:SS) 으로 변환된 문자열(mask 처리된 날짜 형식)
     */
    public static String getDisplayLongDate(String datetm, String mask){
        String str = "";
        
        if (datetm == null || datetm.equals("")) return "";
        
        try{
            datetm = unMask(datetm).replaceAll(" ", "");
            
            if (datetm.length() < 14)
                datetm = stringPadding(datetm, "RIGHT", "0", 14);
            
            str = getDisplayDate(datetm.substring(0, 8), mask) + " " + getDisplayTime(datetm.substring(8));
        }
        catch(Exception e){
            return datetm;
        }
        
        return str;
    }
    
    /**
     * 문자열을 한국시 날짜시간형식으로 변환한다.
     * 예) StringUtil.getDisplayDateString("20131121122710"); => "2013년11월21일 12시27분10초"
     * [주의]
     * 1. 날짜문자열이 null이면 빈문자열로 반환한다.<br>
     * 2. 날짜 문자열이 14자리 미만이면 오른쪽에 0을 채워서 변환해준다. (CUtil.getDisplayDateString("20131121"); => "2013년11월21일 00시00분00초")<br>
     *     반대로 14자리 이상이면 14자리까지 절삭하여 반환한다. (CUtil.getDisplayDateString("20131121122710123", "-"); => "2013년11월21일 12시27분10초")<br>
     * 3. 문자열이 숫자인지는 검사를 하지 않는다. (CUtil.getDisplayDateString("ABCDEFGHIJKLMN"); => "ABCD년EF월GH일 IJ시KL문MN초")<br>
     * 4. 날짜형식으로 변환된 값이 다시 들어올 경우 마스크를 제거한 후 다시 변환해 준다. (CUtil.getDisplayDateString("2013/11/21 12:27:10"); => "2013년11월21일 12시27분10초")
     * @author Evan
     * @param String datetm : "YYYYMMDDHH24MISS" 문자열
     * @return String : 한국식 날짜시간형식(년월일) 으로 변환된 문자열
     */
    public static String getDisplayDateString(String datetm){
        String str = "";
        
        if (datetm == null || datetm.equals(""))    return "";
        
        try{
            datetm = unMask(datetm).replaceAll(" ", "");
            
            if (datetm.length() < 14)
                datetm = stringPadding(datetm, "RIGHT", "0", 14);
            
            str = datetm.substring(0, 4) + "년" + datetm.substring(4, 6) + "월" + datetm.substring(6, 8) + "일 " + datetm.substring(8, 10) + "시" + datetm.substring(10, 12) + "분" + datetm.substring(12, 14) + "초";
        }
        catch(Exception e){
            return datetm;
        }
        
        return str;
    }
    
    /**
     * 날짜마스크를 해제한다. "2000-10-20" -> "20001020"
     * @author Evan
     * @param String date : "YYYY-MM-DD"문자열
     * @return String : "YYYYMMDD" 문자열
     */
    public static String getRealDate(String date){
        return replace(date, "-", "");
    }
    
    /**
     * 문자열 내의 특정 문자를 다른 문자열로 바꾼다.
     * @author Evan
     * @param String src : 문자열
     * @param String oldstr : 특정문자
     * @param String newstr : 바꿀문자
     * @return String : 결과값
     */
    public static String replace(String src, String oldstr, String newstr){
        StringBuffer dest = null;
        
        try{
            if (src == null) 
                return null;
            
            dest = new StringBuffer("");
            
            int  len = oldstr.length();
            int  srclen = src.length();
            int  pos = 0;
            int  oldpos = 0;

            while ((pos = src.indexOf(oldstr, oldpos)) >= 0) {
                dest.append(src.substring(oldpos, pos));
                dest.append(newstr);
                oldpos = pos + len;
            }

            if (oldpos < srclen)
                dest.append(src.substring(oldpos, srclen));
        }
        catch (Exception e){
            return src;
        }
        
        return dest.toString();
    }
    
    /**
     * String을 int값으로 변환한다.
     * @author Evan
     * @param String str : int값으로 변환될 String문자열
     * @return int : 변환된 int 값
     */
    public static int stringToInt(String str){
        if (str == null ) 
            return 0;        
            
        return (Integer.valueOf(str).intValue());
    }
    
    /**
     * int값을 String으로 변환한다.
     * @author Evan
     * @param int i : String으로 변환될 int값
     * @return String : 변환된 String 값
     */
    public static String intToString(int i){
        return (new Integer(i).toString());
    }
    
    /**
     * 문자열에 원하는 문자(chr)를 특정한 문자열로 바꾸어 준다.
     * @author Evan
     * @param String buff : 기준문자열
     * @param char cmp : 바꾸고자하는 문자열
     * @param String cha : 바꿀 문자열 
     * @return String : 바뀐 문자열 
     */
    public static String changeCharToString(String buff, char cmp, String cha){ 
        StringBuffer target = new StringBuffer();
        
        if (buff == null || buff.length() < 1){
            return "";  
        }
         
        for (int i = 0; i < buff.length(); i++){       
            if (buff.charAt(i) == cmp)
                target.append(cha);
            else
                target.append(buff.charAt(i));  
        }
    
        return target.toString();
    }
    
    /**
     * 두 문자열을 비교하여 값이 같을 경우 원하는 특정 문자열을 아니라며 원래 비교대상 문자열을 반환한다.
     * [주의]
     * 1. 문자열을 비교할 때 공백을 제거하지 않는다. 즉, StringUtil.decode("ABC   ", "ABC", "true", "false")의 결과는 "false" 이다.
     * 2. 비교대상 문자열이 null이면 빈문자열로 변환한 후 비교한다.
     * @author Evan
     * @param String value : 비교대상이 되는 문자열
     * @param String cmp : 비교할 문자열
     * @param String mov : 문자열을 비교하여 같을때 반환될 문자열 
     * @return String : 문자열을 비교하여 같다면 param 으로 받은 반환될 문자열을 리턴하고 아닌경우 비교대상 문자열을 리턴 
     */
    public static String decode(String value, String cmp, String mov){
        return decode(value, cmp, mov, value);
    }
    
    /**
     * 두 문자열을 비교하여 결과에 따라 문자열을 반환한다.
     * 1. 문자열을 비교할 때 공백을 제거하지 않는다. 즉, StringUtil.decode("ABC   ", "ABC", "true", "false")의 결과는 "false" 이다.
     * 2. 비교대상 문자열이 null이면 빈문자열로 변환한 후 비교한다.
     * @author Evan
     * @param String value : 비교대상이 되는 문자열
     * @param String cmp : 비교할 문자열
     * @param String mov : 문자열을 비교하여 같을때 반환될 문자열 
     * @param String nt : 문자열을 비교하여 같지않을 반환될 문자열 
     * @return String : 문자열을 비교하여 같다면 param 으로 받은 반환될 문자열을 리턴하고 아닌경우 비교대상 문자열을 리턴 
     */
    public static String decode(String value, String cmp, String mov, String nt){
        value = nvl(value, "");
        
        if (value.equals(cmp) == true)
            return mov;
            
        return nt;
    }
    
    /**
     * 문자열을 받아서 Enter Key를 특정문자열(`)로 변환하거나 특정문자열을 Enter key로 변환함
     * @author Evan
     * @param String str : 변환대상 
     * @param int nFlag : 변환방향 
     * @return String : Enter Key => (`), (`) => Enter Key로 변환
     */
    public static String convertRN(String str, int nFlag){
        StringBuffer dbStr = new StringBuffer();
        int i = 0;
        
        if (str == null){
            return "";  
        }
        else{
            if (nFlag > 0){ // 양수이면 Enter Key를 `로 변환
                str = str.replace('\r', '`');
                str = str.replace('\n', '`');
                
                return str;
            }
            else{           // 음수이면 `를 Enter Key로 변환
                for (; i < str.length(); i++){
                    if ((str.charAt(i) == '`') && ((i+1) < str.length()) && (str.charAt(i+1) == '`')){
                        i++;
                        dbStr.append("\r\n");
                    }   
                    else{
                        dbStr.append(str.charAt(i));    
                    }               
                }
            }
        }
        
        return  dbStr.toString();
    }
    
    /**
     * 문자열을 받아서 Enter Key를 특정문자열(<BR>)로 변환하거나 특정문자열을 Enter key로 변환함
     * @author Evan
     * @param String str : 변환대상 
     * @param int nFlag : 변환방향 
     * @return String : Enter Key => (<BR>), (<BR>) => Enter Key로 변환
     */
    public static String convertBR(String str, int nFlag){
        StringBuffer fileStr = new StringBuffer();
        int i = 0;
        int lasti = 0;
        
        if (str == null){
            return "";  
        }
        else{
            if (nFlag > 0){     // 양수이면 Enter Key를 `<BR>`로 변환
                for (; i < str.length(); i++){
                    if (str.charAt(i) == '\r'){
                        fileStr.append("<BR>");
                    }   
                    else if (str.charAt(i) == '\n'){ 
                        ;
                    }   
                    else{
                        fileStr.append(str.charAt(i));  
                    }               
                }
                                
                return fileStr.toString();
            }
            else{               // 음수이면 <BR>를 Enter Key로 변환
                i = str.indexOf("<BR>"); 
                
                while ((i != -1) && (i < str.length())){
                    fileStr.append(str.substring(lasti, i));
                    fileStr.append("\\r\\n");
                    
                    i += 4;
                    lasti = i;
                    
                    i = str.indexOf("<BR>", lasti); 
                }
                
                if (i < str.length()){
                    fileStr.append(str.substring(lasti, str.length()));
                }               
            }
        }
        
        return  fileStr.toString();
    }
    
    /**
     * 문자열을 받아서 Enter Key를 유닉스용 Enter로 변환
     * @author Evan
     * @param String str : 변환대상 
     * @return String : Enter Key => 유닉스용 Enter로 변환
     */
    public static String convertUnixRN(String str){
        StringBuffer fileStr = new StringBuffer();
        int i = 0;
        
        if (str == null){
            return "";  
        }
        else{
            for (; i < str.length(); i++){
                if (str.charAt(i) == '\r' || str.charAt(i) == '\n'){ 
                    fileStr.append(" ");;
                }   
                else{
                    fileStr.append(str.charAt(i));  
                }               
            }
                            
            return fileStr.toString();
        }
    }
    
    /**
     * 문자열을 받아서 Enter Key를 TextArea Enter로 변환
     * @author Evan
     * @param String str : 변환대상 
     * @return String : Enter Key => TextArea Enter로 변환
     */
    public static String convertTextArea(String str){
        StringBuffer fileStr = new StringBuffer();
        int i = 0;
        
        if (str == null){
            return "";  
        }
        else{
            for (; i < str.length(); i++){  
                if (str.charAt(i) == '\r'){ 
                    fileStr.append("\\r\\n");
                }
                else if (str.charAt(i) == '\n'){
                    fileStr.append("");
                }   
                else{
                    fileStr.append(str.charAt(i));  
                }               
            }
                            
            return fileStr.toString();
        }
    }
    
    /**
     * 문자열의 NULL CHECK 및 int형 default값 0셋팅
     * @author Evan
     * @param int flag :    0 이면 문자형 비교하여 기본 공백을 넣는다.
     *                                  1 이면 숫자형 비교하여 기본 0을 넣는다 
     * @param String strData : 검색할 문자열
     * @return String 
     */
    public static String insertCheck(int flag, String strData){
        if (strData != null) 
            strData = strData.trim();

        if (flag == 0){             // 문자형
            if (strData == null){
                strData = " ";  // 저장시 기본 공백을 넣는다.
            }
            else if (strData.equals("")){
                strData = " ";  // 저장시 기본 공백을 넣는다.
            }
        }
        else if (flag == 1){    // 숫자형
            if (strData == null){
                strData = "0";  // 저장시 기본 0을 넣는다.
            }
            else if (strData.equals("")){
                strData = "0";  // 저장시 기본 0을 넣는다.
            }
        }
        
        return strData;
    }
    
    /**
     *  길이를 바이트 단위로 계산하여 문자열을 자른다. 한글 일 경우 반바이트는 절삭한다.
     *  절삭된 문자열이라면 뒤에 "..."이 붙는다.
     *  
     *  String temp = StringUtil.substring("절삭할 문자열입니다.", 10);
     *  temp = StringUtil.substring("절삭할", 8);
     *  
     *  [결과]
     *  temp ==>절삭할 문...
     *  temp ==>절삭할
     *  
     * @author Evan
     * @param String str :  문자열 
     * @param int length : 절삭할 길이 
     * @return String : 절삭된 문자
     */
    public static String substring(String str, int length)  {
        if (str == null || length < 4) return str;
        
        int len = str.length();
        int cnt = 0, index = 0;
        
        while (index < len && cnt < length){
            // 1바이트 문자라면(영문)
            if (str.charAt(index++) < 256)
                cnt ++;
            else
                cnt += 2;
        }
        
        if (index < len && length >= cnt)
            str = str.substring(0, index);
        else if (index < len && length < cnt)
            str = str.substring(0, index - 1);
        
        return str;
    }
    
    /**
     * 문자열의 바이트갯수를 구한다.
     * @author Evan
     * @param String strText :  문자열 
     * @return String : 문자열의 바이트수
     */
    public static int getByteLength(String strText){
        byte[] byteArray = strText.getBytes();
        return byteArray.length;
    }
    
    /**
     * 문자열의 바이트갯수만큼의 문자열을 구한다.
     * @author Evan
     * @param String str :  문자열 
     * @param int byteLength : 바이트
     * @return String : 바이트수만큼의 문자열 
     */
    public static String getByteLengthString(String str, int byteLength){
        if (getByteLength(str) > byteLength)
            return getByteLengthString(str.substring(0, str.length()-1), byteLength);
            
        return str;
    }
    
    /**
     * 해당 문자열의 소수점을 digit 단위로 반올림 처리
     * 
     * double formatted = StringUtil.format("1234.67789", 2);
     * formatted double ==> 1234.68
     *  
     * @author Evan
     * @param String str_number :  String representation of the number to truncate digits 
     * @param int digits : the number of count to be remained after the fraction point
     * @return double 
     */
    public static double format(String str_number, int digits) {
        String pattern = "###";
        double value = -1.;
        
        for (int i = 0; i < digits; i++) {
            if (i == 0) 
                pattern += ".";
                
            pattern += "0";
        }
        
        try {
            value = Double.parseDouble(str_number);
        } 
        catch(NumberFormatException e) {
            return 0.0;
        }
        
        return customFormat(pattern, value);
    }
    
    /**
     * 해당 숫자(더블형)의 소수점을 digit 단위로 반올림 처리
     * 
     * double formatted = StringUtil.format(1234.67789, 2);
     * fformatted ==> 1234.68
     *  
     * @author Evan
     * @param double number :  the number to truncate digits 
     * @param int digits : the number of count to be remained after the fraction point
     * @return double 
     */
    public static double format(double number, int digits) {
        return format(""+number, digits);
    }
    
    /**
     * This method actually does all for number formatting
     * 
     * double formatted = StringUtil.format(1234.67789, 2);
     * fformatted ==> 1234.68
     *  
     * @author Evan
     * @param String pattern :  pattern to apply to the given double value
     * @param double value : number to be formatted
     * @return double 
     */
    private static double customFormat(String pattern, double value ) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        
        try {
            return Double.parseDouble(output);
        } 
        catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    /**
     * 마스크 제거 ("/", "-", ":", ",")
     * @author Evan
     * @param String value :  문자열
     * @return String : 마스크를 제거한 문자 
     */
    public static String unMask(String value) {
        String ls_str = "";
        
        if (value == null) return ls_str;
        
        ls_str = value;
        
        ls_str = replace (ls_str, "/", "");
        ls_str = replace (ls_str, "-", "");
        ls_str = replace (ls_str, ":", "");
        ls_str = replace (ls_str, ",", "");
        
        return ls_str;
    }
    
    /**
     * 지정한 문자를 지정한 방향으로 지정한 크기만큼 채워 넣는다.
     * 
     * StringUtil.stringPadding("1", "LEFT", "0", 2);
     * 
     * @author Evan
     * @param String value :  문자열
     * @param String direct :  방향 (LEFT, RIGHT)
     * @param String padchar :  채울문자
     * @param int padlen :  채울크기
     * @return String 
     */
    public static String stringPadding(String value, String direct, String padchar, int padlen) {
        String lstrPad = value.trim();
        
        if (lstrPad.length() == padlen)
            return lstrPad;
        else{
            int lintGap = padlen - lstrPad.length();
            
            if (direct.equals("LEFT")){
                for (int i = 0; i < lintGap; i++) lstrPad = padchar + lstrPad;
            }
            else{
                for (int i = 0; i < lintGap; i++) lstrPad = lstrPad + padchar;
            }
        }
        
        return lstrPad;
    }
    
    /**
     * 문자열 자름
     * 
     * StringUtil.stringPadding("1", "LEFT", "0", 2);
     * 
     * @author Evan
     * @param String value :  자를 문자열
     * @param String delimit :  구분자
     * @return String 
     */
    public static String[] split(String value, String delimit) {
        if (value == null)  return null;
        
        Vector<String> lv_split = new Vector<String>(1);
        String[] ls_split   = null;
    
        while (value.indexOf(delimit) != -1) {
            lv_split.add(value.substring(0, value.indexOf(delimit)));
            
            value = value.substring(value.indexOf(delimit) + 1);
        }
        
        lv_split.add(value);
        
        ls_split = new String[lv_split.size()];
        
        for (int i = 0; i < lv_split.size(); i++) {
            ls_split[i] = (String) lv_split.elementAt(i);
        }
        
        return ls_split;
    }
    
    /**
     * 구분자를 포함한 문자를 배열로 넘겨준다.
     * @author Evan
     * @param String value :  문자(구분자는 |)
     * @return String 
     */
    public static String[] tokenToArray(String value){
        return tokenToArray(value, "|");
    }
    
    /**
     * 구분자를 포함한 문자를 배열로 넘겨준다.
     * @author Evan
     * @param String value :  문자(구분자는 |)
     * @param String determiter :  구분자
     * @return String 
     */
    public static String[] tokenToArray(String value, String determiter){
        StringTokenizer st  = new StringTokenizer(value, determiter);
        String[] lstrRtn    = new String[st.countTokens()];
        
        for (int i = 0; st.hasMoreTokens(); i++)
            lstrRtn[i] = st.nextToken();
            
        return lstrRtn;
    }
    
    /** 
     * 공백(space)를 "&nbsp;"로 변환한다.
     * @author Evan
     * @param value : 문자열
     * @return String
     */ 
    public static String spaceToNbsp(String value){
        String lstrTemp     = "";
        
        if (value.length() < 1) return "";
        
        for (int i = 0; i < value.length(); i++){
            if (value.charAt(i) == ' ')
                lstrTemp += "&nbsp;";
            else
                lstrTemp += value.charAt(i);
        }
        
        return lstrTemp;
    }
    
    /** 
     * <BR>태그를 공백으로 처리한다.
     * @author Evan
     * @param value : 문자열
     * @return String
     */
    public static String brTagToSpace(String value){
        if (value.length() < 1) return "";
        
        while (value.indexOf("<BR>") != -1){
            if (value.indexOf("<BR>") != -1)
                value = value.substring(0, value.indexOf("<BR>")) + " " + value.substring(value.indexOf("<BR>") + 4);
        }
        
        return value;
    }
    
    /** 
     * NULL이거나 ""이면 "&nbsp;"로 치환
     * @author Evan
     * @param value : 문자열
     * @return String : NULL이거나 ""이면 "&nbsp;"로 치환된 문자열
     */
    public static String nbsp(String value){
        if (value == null || value.length() < 1 || value.trim() == "")
            return "&nbsp;";
        else
            return value;
    }
    
    /** 
     * 문자열을 Trim 한다.
     * @author Evan
     * @param str : 문자열
     * @return String 
     */
    public static String trim(String str) {
        if (str == null || str.equals("")) {
            str = "";
        } 
        else {
            str = decode(str);
        }
        return str;
    }
    
    public static String decode(String str) {
        if (str != null) {
            str = str.trim();
        }
    
        return str;
    }
    
    /** 
     * 오른쪽으로 부터 길이를 계산하여 문자열을 cut한다.
     * @author Evan
     * @param String s : 문자열
     * @param int i : 절삭할 길이.
     * @return String 
     */
    public static String getRightSubstring(String s, int i) {
        return s.substring(s.length() - i, s.length());
    }
    
    /** 
     * 왼쪽으로 부터 길이를 계산하여 문자열을 cut한다
     * @author Evan
     * @param String s : 문자열
     * @param int i : 절삭할 길이.
     * @return String 
     */
    public static String getLeftSubstring(String s, int i) {
        return s.substring(0, s.length() - i);
    }
    
    /**
     * 8859_1 ---> KSC5601 문자열로 변환
     * @param UnicodeStr    : UnicodeStr
     * @return              : String, KSC5601로 변환된 String
     */
    public static String uniToKsc(String UnicodeStr){
        try{
            if (UnicodeStr == null){
                return null;    
            }
            else{
                return new String(UnicodeStr.getBytes("8859_1"), "KSC5601");    
            }
        }
        catch (Exception e){
            return null;
        }
    }
    
    /**
     * 포맷주기
     * @param sVal
     * @param sPattern
     * @return
     */
    public static String getFormatData(String sVal, String sPattern){
        String sRet = null;
        
        if (sVal.length() ==0 ) return sVal;
        
        if ("DATE".equals(sPattern)){
            sRet = getDisplayDate(sVal, "-");
        }
        else if ("DATET".equals(sPattern)){
            sRet = getDisplayLongDate(sVal, "-");
        }
        else if ("TIME".equals(sPattern)){
            sRet = getDisplayTime(sVal);
        }
        //else if ("TEL".equals(sPattern)){
        //  sRet = getDisplayPhoneMPVA(sVal);
        //}
        //else if ("WORKINGTERM".equals(sPattern)){
        //  sRet = getDisplayPeriod(sVal);
        //}
        //else if ("POST".equals(sPattern)){
        //  sRet = getDisplayPostNo(sVal);
        //}
        //else if ("SID".equals(sPattern)){
        //  sRet = StringUtil.getDisplayJumin(sVal);
        //}
        else{
            sRet = sVal;
        }

        return sRet;
    }
    
    /**
     * 화폐 단위 변경
     * ex)
     * StringUtil.getFormatMoney(111221);
     * @param sVal 
     * @return String - 111,221
     * @author cdy
     */
    public static String getFormatMoney(int sVal){
        return String.format("%,d", sVal);
    }
    
    /**
     * 
     * <pre>
     * 1. MethodName    : getListSize
     * 2. ClassName     : StringUtil
     * 3. Comment       : 리스트 사이즈 구하는 메서드
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2013. 12. 17. 오전 10:54:13
     * </pre>
     *   @param list
     *   @return
     *   @return int
     */
    public static int getListSize(List<?> list){
        return (list != null) ? list.size() : 0;
    }
    
    
    /**
     * ArrayIndexOutOfBoundsException 시 배열 공백 스트링 리턴
     * ex)
     * StringUtil.splitDataGet(arlStringVal,0);
     * @param arlStringVal 스트링 배열
     * @param index 인덱스
     * @return String 배열이 null 이나 ArrayIndexOutOfBoundsException 발생 시 공백 처리
     * @author cdy
     */
    public static String splitDataGet(String[] arlStringVal,int index){
        if(arlStringVal==null ||arlStringVal.length ==0){
            return "";
        }
        
        try {
            return arlStringVal[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return "";
        }
    }
    
    /**
     * 
     * <pre>
     * 1. MethodName    : maskingString
     * 2. ClassName     : StringUtil
     * 3. Comment       : 입력 String 값을 masking 
     *                    예1 ) 전체 마스킹 : StringUtil.maskToString("010-11@11-2222", -1, 35);
     *                        > 결과 : ###-##@##-####  
     *                    예2 ) 부분 마스킹 : StringUtil.maskToString("010-11@11-2222", 2, 35);
     *                        > 결과 : ###-##@##-##22
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2013. 12. 27. 오후 12:07:22
     * 6. 참고            :  
     *   ------------------------------------------   
     *   |  masking 문자  |   masking 문자 바이트     |
     *   ------------------------------------------
     *   |     '*'       |           42           |
     *   ------------------------------------------
     *   |     '#'       |           35           |
     *   ------------------------------------------
     *   |     'O'       |           79           |
     *   ------------------------------------------   

     * </pre>
     *   @param val         입력 문자열
     *   @param positionCnt 마스킹 제외할 마지막 자릿수
     *   @param maskByte    마스킹에 사용할 문자의 바이트 값
     *   @return
     *   @return String
     */
    public static String maskToString(String val, int positionCnt, int maskByte){

        String maskedStr    = null;
        byte[] bytes        = null;
        byte[] maskedBytes  = null;
        
        int bytesLength     = 0;    
        
        if(val != null && val != ""){
            bytes       = val.getBytes();
            bytesLength = bytes.length;
            
            if(bytesLength > 0){
                maskedBytes = new byte[bytesLength];
                
                for(int i = 0 ; i < bytesLength ; i++){
                    byte byteVal = bytes[i];
                    
                    if(byteVal != 45 && byteVal != 64){     // '-' 혹은 '@'은 마스킹 제외.
                        if( positionCnt == -1 
                        || (positionCnt != -1 && i < (bytesLength - positionCnt)))
                            byteVal = (byte) maskByte; //42;    // '*'로 마스킹                                 
                    }
                    
                    maskedBytes[i] = byteVal;
                }               
            }
            maskedStr = new String(maskedBytes,0,bytesLength);          
        }
        return maskedStr;
    }
    /**
     * 
     * <pre>
     * 1. MethodName    : maskToStringAsAsterix
     * 2. ClassName     : StringUtil
     * 3. Comment       : '*'으로 masking.
     * 예제) StringUtil.maskToStringAsAsterix("010-1111-2222", 2);
     * 결과) ***-****-**22
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2013. 12. 27. 오후 12:23:50
     * </pre>
     *   @param val
     *   @param positionCnt
     *   @return
     *   @return String
     */
    public static String maskToStringAsAsterix(String val, int positionCnt){
        return maskToString(val, positionCnt, 42);
    }
    /**
     * 
     * <pre>
     * 1. MethodName    : maskToStringAsSharp
     * 2. ClassName     : StringUtil
     * 3. Comment       : '#'으로 masking.
     * 예제) StringUtil.maskToStringAsSharp("010-1111-2222", 2);
     * 결과) ###-####-##22
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2013. 12. 27. 오후 12:31:06
     * </pre>
     *   @param val
     *   @param positionCnt
     *   @return
     *   @return String
     */
    public static String maskToStringAsSharp(String val, int positionCnt){
        return maskToString(val, positionCnt, 35);
    }
    /**
     * 
     * <pre>
     * 1. MethodName    : maskToStringAsZero
     * 2. ClassName     : StringUtil
     * 3. Comment       : 'O'로 masking.
     * 예제) StringUtil.maskToStringAsZero("010-1111-2222", 2);
     * 결과) OOO-OOOO-OO22
     * 4. 작성자           : leejinwon
     * 5. 작성일           : 2013. 12. 27. 오후 12:29:46
     * </pre>
     *   @param val
     *   @param positionCnt
     *   @return
     *   @return String
     */
    public static String maskToStringAsZero(String val, int positionCnt){
        return maskToString(val, positionCnt, 79);
    }
    
    //문자열 인코딩 체크
    public static void chk_encode(String str) {
        try{
            String charSet[] = {"utf-8","euc-kr","8859_1"};
            String fileName = str;
            for(int i = 0; i < charSet.length; i++) {
                for(int j = 0; j < charSet.length; j++) {
                    System.out.println(charSet[i] + " to " + charSet[j] + " = " + new String(fileName.getBytes(charSet[i]),charSet[j]));
                 }
             }
        }
        catch(Exception ex){}
    }
}
