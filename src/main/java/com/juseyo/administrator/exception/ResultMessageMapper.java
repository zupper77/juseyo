/**
 * @file	ResultMessageMapper.java
 * @brief   간단한 설명 
 * @author  개발3/파트2
 * @author  김한주
 * @date    생성 : 2014. 5. 8.
 * @date    최종수정: 2014. 5. 8.
 */
package com.juseyo.administrator.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;

/**
 * @brief ResultMessageMapper
 * @author 개발3팀/파트2/김한주
 * @version 1.0
 * @date 생성: 2014. 5. 8.
 * @date 최종수정: 2014. 5. 8.
 * @remark
 */
public class ResultMessageMapper {

    private static String MESSAGE = "message";
    private static String SUCCESS = "success";

    /**
     * 
     * @brief addFail
     * @details
     * @param model
     * @param e
     */
    public static void addFail(Model model, Exception e) {
        model.addAttribute(SUCCESS, false);
        model.addAttribute(MESSAGE, e.getClass().getSimpleName());
    }

    /**
     * @brief addSuccess
     * @details
     * @param model
     */
    public static void addSuccess(Model model) {
        model.addAttribute(SUCCESS, true);
        model.addAttribute(MESSAGE, "");
    }

    /**
     * @brief addSuccess
     * @details
     * @param model
     */
    public static Map<String, Object> addSuccess() {
        Map<String, Object> map = new HashMap();
        map.put(SUCCESS, true);
        map.put(MESSAGE, "");
        return map;
    }

    /**
     * @brief addSuccess
     * @details
     * @param model
     */
    public static Map<String, Object> addFail(Exception e) {
        Map<String, Object> map = new HashMap();
        map.put(SUCCESS, false);
        map.put(MESSAGE, e.getClass().getSimpleName());
        return map;
    }
}
