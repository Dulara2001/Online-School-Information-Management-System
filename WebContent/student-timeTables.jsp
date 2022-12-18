<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/global.css" />
<title>Student | Timetable</title>
</head>
<body class="min-h-screen">

	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<header>
		<div
			class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
			<h1 class="font-bold text-3xl">GISMS</h1>
			<form action="Logout">
				<button type="submit"
					class="bg-indigo-600 py-2 px-5 rounded-3xl text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
			</form>
		</div>
		<div class="md:px-4 px-2 mb-7">
			<h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">
				Timetables
			</h2>
			<nav
				class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
				<div class="mb-3">
					<h4 class="text-white">
						Student info | <a
							class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl"
							href="Profile">Profile</a>
					</h4>
				</div>
				<div class="my-4 ml-2 space-x-3 flex justify-center">
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
				</div>
			</nav>
		</div>
	</header>
	
	<section class="mx-2 sm:mx-4 md:mx-4 flex flex-col items-center justify-center h-full">
		<c:if test="${timetable.image != null}">
			<div class="text-white font-medium flex flex-wrap space-x-3 mb-4">
				<p class="bg-indigo-500 py-2 px-4 rounded-3xl shadow-2xl">Year: <c:out value="${timetable.year}" /></p>
				<p class="bg-indigo-500 py-2 px-4 rounded-3xl shadow-2xl">Grade: <c:out value="${timetable.grade}" /></p>
				<p class="bg-indigo-500 py-2 px-4 rounded-3xl shadow-2xl">Class: <c:out value="${timetable.className}" /></p>
			</div>
			<img class="rounded-2xl shadow-2xl" src="./uploads/timetables/<c:out value="${timetable.image}" />" alt="timetable"/>
		</c:if>
		<c:if test="${timetable.image == null}">
			<div class="bg-gray-900 bg-opacity-80 w-full max-w-xl rounded-2xl shadow-2xl p-6">
    			<p class="text-white text-center font-semibold md:text-4xl sm:text-3xl text-2xl mb-4">No timetables uploaded yet!</p>
  			</div>
		</c:if>
	</section>

</body>
</html>