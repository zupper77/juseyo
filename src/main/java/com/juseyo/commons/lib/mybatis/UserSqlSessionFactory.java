/**
 * @file    UserSqlSessionFactory.java
 * @brief   Master/Slave DB연결을 위한 Factory class 
 * @author  개발지원 1팀
 * @author  성우현
 * @date    생성: 2014-03-14
 * @date    최종수정: 2014-04-25
 */
package com.juseyo.commons.lib.mybatis;

/**
 * @breif   Master/Slave/SMS DB연결을 위한 Factory Class
 * @author  개발지원1팀/제비파트/성우현
 * @version 1.0.0
 * @date    생성: 2014-03-14
 * @date    수정: 2014-04-25
 * @remark
 */
public class UserSqlSessionFactory {
    private UserSqlSessionMaster sqlMaster;
    
    public UserSqlSessionFactory(){}
    
    /**
     * @breif  생성
     * @param sqlMaster Master 처리용 메서드를 포함한 UserSqlSessionMaster 객체
     * @param sqlSlave Master 처리용 메서드를 포함한 UserSqlSessionSlave 객체
     * @param sqlMasterSelect Master select 처리용 메서드를 포함한 UserSqlSessionMasterSelect 객체
     * @param sqlSMS SMS 처리용 메서드를 포함한 UserSqlSessionSMS 객체
     */
    public UserSqlSessionFactory(UserSqlSessionMaster sqlMaster){
        this.sqlMaster = sqlMaster;
    }
    /*
    public UserSqlSessionFactory(UserSqlSessionMaster sqlMaster, UserSqlSessionSlave sqlSlave, UserSqlSessionMasterSelect sqlMasterSelect, UserSqlSessionSMS sqlSMS){
        this.sqlMaster = sqlMaster;
        this.sqlSlave = sqlSlave;
        this.sqlMasterSelect = sqlMasterSelect;
        this.sqlSMS = sqlSMS;
    }
    */

    /**
     * @breif  입력/수정/삭제 DB
     * @return  UserSqlSessionMaster 객체
     */
    public UserSqlSessionMaster cud() throws Exception {
        return sqlMaster;
    }
}
