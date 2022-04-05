<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html lang="en" xmlns:th="http://www.thymeleaf.org">

        <head>
            <%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>
                <style>
                    .error {
                        font-size: 1rem;
                        color: red;
                    }
                </style>
        </head>

        <body style="overflow: visible;">
            <div class="header">
                <!-- -----------------HEADER-------------------- -->
                <%@include file="/WEB-INF/views/user/teacher/header.jsp"%>
                    <!-- -----------------END OF HEADER-------------------- -->
                    <!-- -----------------MENU BAR-------------------- -->
                    <%@include file="/WEB-INF/views/user/teacher/menubar.jsp"%>
                        <!-- -----------------END OF MENU BAR-------------------- -->
            </div>


            <!-- partial -->
            <div class="main-panel">
                <div class="content-wrapper">




                    <div class="row">


                        <div class="col-lg-12 grid-margin stretch-card">
                            <div class="card">
                                <div class="card-body">
                                    <h1 style="text-align: center;">GRADE FOR REPORT</h1>
                                    <c:set value="${report}" var="report" />
                                    <c:set value="${student}" var="student" />
                                    <h5>Report Name: ${report.name}</h5>
                                    <h5>Student Name:${student.name }</h5>
                                    <c:if test="${editAction == null }">
                                        <form:form action="${pageContext.request.contextPath}/processGrade" method="POST" modelAttribute="pointDetail">
                                            <form:hidden path="id" />
                                            <form:hidden path="reportId" />
                                            <form:hidden path="studentId" />
                                            <form:hidden path="teacherId" />
                                            <br>
                                            <form:input path="point" />
                                            <form:errors path="point" cssClass="error" />
                                            <br>
                                            <br>
                                            <input type="submit" class="btn btn-primary mb-2" value="SAVE" />
                                        </form:form>
                                    </c:if>
                                    <c:if test="${editAction == true }">
                                        <form:form action="${pageContext.request.contextPath}/processEditGrade" method="POST" modelAttribute="pointDetail">
                                            <form:hidden path="id" />
                                            <form:hidden path="reportId" />
                                            <form:hidden path="studentId" />
                                            <form:hidden path="teacherId" />
                                            <br>
                                            <form:input path="point" />
                                            <form:errors path="point" cssClass="error" />
                                            <br>
                                            <br>
                                            <input type="submit"  />
                                        </form:form>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                    </div>

                </div>


            </div>

        

        </body>

        </html>