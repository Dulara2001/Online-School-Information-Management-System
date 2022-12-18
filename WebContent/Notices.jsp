<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="./css/global.css" />
<title>Notices | SIMS</title>
</head>
<body>

	<!-- Navigation bar -->

	<%
	String userState = (String) session.getAttribute("userState");
	%>

	<c:set var="userState" scope="session" value="<%=userState%>" />

	<header>
		<div
			class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
			<h1 class="font-bold text-3xl">SIMS</h1>
			<form action="Logout">
				<button type="submit"
					class="bg-indigo-600 py-2 px-5 text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
			</form>
		</div>
		<div class="md:px-4 px-2 mb-7">
			<h2
				class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">
				Notices</h2>
			<nav
				class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
				<div class="mb-3">
					<h4 class="text-white">
						<span class="capitalize"><%=userState%></span> info | <a
							class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl"
							href="Profile">Profile</a>
					</h4>
				</div>


				<div class="my-4 ml-2 space-x-3 flex justify-center">
					<c:if test="${userState == \"admin\"}">
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
							<a href="AddNotices.jsp">Add Notice</a>
						</button>
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-4 rounded-3xl">
							<a href="enroll.jsp">Enroll</a>
						</button>
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-4 rounded-3xl">
							<a href="Notices">Notices</a>
						</button>
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-4 rounded-3xl">
							<a href="viewInquiry.jsp">Inquiry</a>
						</button>
					</c:if>
					<c:if test="${userState == \"student\"}">
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
							<a href="Results.jsp">Results</a>
						</button>
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
							<a href="Notices">Notices</a>
						</button>
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
							<a href="ViewStudentTimetables">Timetables</a>
						</button>
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
							<a href="SupportDesk.jsp">Support</a>
						</button>
					</c:if>
					<c:if test="${userState == \"teacher\"}">
						<button
							class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
							<a href="AddNotices.jsp">Add Notice</a>
						</button>
					
					</c:if>
				</div>
			</nav>
		</div>
	</header>

	<!-- Notices view -->

	<div class="sm:mx-4 mx-2 flex flex-col items-center">
		<div>
			<h4 class="text-white text-3xl font-medium mb-3">Most Recent
				First</h4>
		</div>
		<div class="text-white max-w-4xl">
			<c:forEach var="item" items="${notices}">
				<div
				class="bg-gray-500 bg-opacity-95 my-4 p-4 rounded-3xl shadow-2xl">
					<h2 class="text-lg font-medium text-gray-900 mb-2">
						<c:out value="${item.title}" />
					</h2>
					<div class="text-gray-300">
						<c:out value="${item.date}" />
					</div>
					<p>
						<c:out value="${item.description}" />
					</p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>