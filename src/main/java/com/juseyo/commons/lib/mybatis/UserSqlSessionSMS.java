package com.juseyo.commons.lib.mybatis;

import org.apache.ibatis.session.SqlSession;

/**
 * @bried UserSqlSessionSMS
 * @author 개발지원2팀 /간지파트 / 한주희
 * @version 1.0.0
 * @date 생성 : 2014. 4. 18. (오후 2:45:38)
 * @date 최종수정 : 2014. 4. 18.
 * @remark
 * 
 */
public class UserSqlSessionSMS {
private SqlSession sqlSession;
    
    /**
     * @breif 생성자
     * @param sqlSession Master연결에 필요한 SqlSession 객체
     */
    public UserSqlSessionSMS(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    public int insert(String statement) throws Exception {
        return sqlSession.insert(statement);
    }

    public int insert(String statement, Object parameter) throws Exception {
        return sqlSession.insert(statement, parameter);
    }
    
    public int delete(String statement) throws Exception {
        return sqlSession.delete(statement);
    }

    public int delete(String statement, Object parameter) throws Exception {
        return sqlSession.delete(statement, parameter);
    }
}
