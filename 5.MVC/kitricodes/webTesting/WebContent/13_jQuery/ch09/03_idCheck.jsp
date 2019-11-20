<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="id" value="${param.id}"></c:set>
<c:set var="password" value="${param.password}"></c:set>

<c:out value="${id}"></c:out>
<c:out value="${password}"></c:out>