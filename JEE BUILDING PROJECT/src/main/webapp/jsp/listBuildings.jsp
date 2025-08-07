
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>List of Buildings</title></head>
<body>
<h2>Buildings</h2>
<ul>
<% 
    java.util.List buildings = (java.util.List) request.getAttribute("buildings");
    for (Object b : buildings) {
        out.println("<li>" + b.toString() + "</li>");
    }
%>
</ul>
</body>
</html>
