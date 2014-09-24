<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>

<!-- 
    1002 ~ 1005 : 공통사용
    A000 ~ E999 : 알파팀 
    F000 ~ J999 : 브라보팀 사용
    K000 ~ O999 : 찰리팀 사용 
 -->

<c:choose>

     <c:when test="${result_no == '1002'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>
        <c:when test="${result_no == '1003'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>
         <c:when test="${result_no == '1004'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>
         <c:when test="${result_no == '1005'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>
    

    <c:when test="${result_no == 'A000'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>
    

    <c:when test="${result_no == 'F000'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>
    

     <c:when test="${result_no == 'K000'}">
         <c:import url="/WEB-INF/views/exception/1002.jsp" charEncoding="UTF-8" />
    </c:when>   
            
    <c:otherwise>
         <c:import url="/WEB-INF/views/exception/9000.jsp" charEncoding="UTF-8" />
    </c:otherwise>
    
</c:choose>
</body>
</html>
