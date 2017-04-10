<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
    <c:set var="path" value="${pageContext.request.contextPath}" />  
<tr>  
   <td colspan="5">  
            共${pageBean.total}条记录 每页显示${pageBean.pageSize}条  &nbsp;&nbsp;&nbsp;&nbsp;
            当前第${pageBean.pageNum}/${pageBean.pages}页&nbsp;  
       <c:choose>  
           <c:when test="${pageBean.hasPreviousPage eq false}">  
                 &lt&lt首页&nbsp;&lt上页&nbsp;  
           </c:when>  
           <c:otherwise>  
                    <a href="${path}?&pageAction=first${urlParams}">&lt&lt首页&nbsp;</a>&nbsp;  
                    <a href="${path}?pageAction=previous${urlParams}" />&lt上一页</a>  
            </c:otherwise>  
       </c:choose>  
            &nbsp;||&nbsp;  
            <c:choose>  
                <c:when test="${pageBean.hasNextPage eq false}">  
                    &nbsp;下页&gt&nbsp;尾页&gt&gt  
                </c:when>  
                <c:otherwise>  
                    <a href="${path}?&pageAction=next${urlParams}">下一页&gt&nbsp;</a>&nbsp;  
                    <a href="${path}?pageAction=last${urlParams}" />末页&gt&gt</a>  
                </c:otherwise>  
            </c:choose>  
            &nbsp;  
            <SELECT name="indexChange" id="indexChange"  
                onchange="getCurrentPage(this.value);">  
                <c:forEach var="index" begin="1" end="${pageBean.pages}" step="1">  
                    <option value="${index}" ${pageBean.pageNum eq index ? "selected" : ""}>  
                        	第${index}页  
                    </option>  
                </c:forEach>  
            </SELECT>  
            &nbsp;  
            每页显示:<select name="everyPage" id="everyPage" onchange="setEveryPage(this.value);">  
                 <c:forEach var="pageCount" begin="5" end="${pageBean.total}" step="5">                          
                     <option value="${pageCount}" ${pageBean.pageSize eq pageCount ? "selected" : ""}>  
                          ${pageCount}条  
                     </option>  
                </c:forEach>  
            </select>  
        </td>  
    </tr>  
    <div style='display: none'>  
        <a class=listlink id="indexPageHref" href='#'></a>  
    </div>  
    <script>  
    function getCurrentPage(index){   
        var a = document.getElementById("indexPageHref");     
        a.href = '${path}?pageAction=gopage&pageKey='+index+'${urlParams}';          
        a.setAttribute("onclick",'');            
        a.click("return false");     
    }  
    function setEveryPage(everyPage){     
        var a = document.getElementById("indexPageHref");  
        var currentPage = document.getElementById('indexChange').value;  
        a.href = '${path}?pageAction=setpage&pageKey='+everyPage+'${urlParams}';         
        a.setAttribute("onclick",'');            
        a.click("return false");     
    }  
    function sortPage(sortName){      
        var a = document.getElementById("indexPageHref");     
        a.href = '${path}?pageAction=sort&pageKey='+sortName+'${urlParams}';        
        a.setAttribute("onclick",'');        
        a.click("return false");     
    }  
    </script>  