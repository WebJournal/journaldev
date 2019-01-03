<%@page contentType="text/html;charset=UTF-8"%><HTML>
<HEAD>
<TITLE>Web Services Test Client</TITLE>
</HEAD>
<FRAMESET  COLS="220,*">
<FRAME SRC="Method.jsp" NAME="methods" MARGINWIDTH="1" MARGINHEIGHT="1" SCROLLING="yes" FRAMEBORDER="1">
<FRAMESET  ROWS="80%,20%">
<FRAME SRC="Input.jsp" NAME="inputs"  MARGINWIDTH="1" MARGINHEIGHT="1" SCROLLING="yes" FRAMEBORDER="1">
<%
StringBuffer resultJSP = new StringBuffer("Result.jsp");
resultJSP.append("?");
java.util.Enumeration resultEnum = request.getParameterNames();while (resultEnum.hasMoreElements()) {
Object resultObj = resultEnum.nextElement();
resultJSP.append(resultObj.toString()).append("=").append(request.getParameter(resultObj.toString())).append("&");
}
%>
<FRAME SRC="<%=org.eclipse.jst.ws.util.JspUtils.markup(resultJSP.toString())%>" NAME="result"  MARGINWIDTH="1" MARGINHEIGHT="1" SCROLLING="yes" FRAMEBORDER="1">
</FRAMESET>
<NOFRAMES>
<BODY>
The Web Services Test Client requires a browser that supports frames.
</BODY>
</NOFRAMES>
</FRAMESET>
</HTML>