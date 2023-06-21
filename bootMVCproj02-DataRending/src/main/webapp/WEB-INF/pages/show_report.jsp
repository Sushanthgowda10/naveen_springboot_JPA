<%@page isELIgnored="false" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<h1>model attributes data is</h1>
<%-- <b>fav Colors are::<%=Arrays.toString(((String[])request.getAttribute("favColors")))%></b>
<b>nick names are::${nickNames }</b><br>
<b>phoneNumbers are::${phoneNumber}</b><br>
<b>idDetails are::${idDetails}</b><br> --%>
<h3>fav Colors are::</h3>
<c:forEach var="color" items="${favColors}">${color}
</c:forEach>
<h3>nick names are::</h3>
<c:forEach var="names" items="${nickNames}">${names}
</c:forEach>