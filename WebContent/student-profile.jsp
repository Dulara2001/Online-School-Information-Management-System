<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="./css/global.css" />
<title>Student | Profile</title>

</head>
<body>

	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("login.jsp");
		}
	%>


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
			<h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">
				Welcome
				<c:out value="${student.name}" />
			</h2>
			<nav
				class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
				
				<div class="my-4 ml-2 space-x-3 flex justify-center">
					<button
						class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
						<a href="Results.jsp">Results</a>
					</button>
					<button
						class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
						<a href="SupportDesk.jsp">Support</a>
					</button>
				</div>
			</nav>
		</div>
	</header>

	<section
		class="grid grid-rows-1 grid-cols-1 md:grid-cols-7 gap-5 md:px-4 px-2 mb-4">
		<div class="md:col-span-5">
			<h2 class="text-white font-semibold md:text-3xl text-2xl mb-4">Recent
				Notices</h2>
			<div class="flex flex-col space-y-4">
				<c:forEach begin="0" end="2" varStatus="loop">
					<div class="bg-gray-500 bg-opacity-95 p-4 rounded-3xl shadow-2xl w-full">
						<div class="text-gray-900 text-lg font-bold mb-2">${recentNotices[loop.index].getTitle()}</div>
						<div class="text-gray-300">${recentNotices[loop.index].getDate().split(" ")[0]}</div>
						<div class="text-white">${recentNotices[loop.index].getDescription()}</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- student data -->
		<aside class="md:col-span-2 bg-gray-500 bg-opacity-95 p-4 shadow-xl rounded-lg flex flex-col items-center">
			
			<h3 class="font-semibold md:text-3xl text-2xl text-black-900 mb-3">
				<c:out value="${student.name}" />
			</h3>
			<p class="text-white text-lg font-medium">
				Grade :
				<c:out value="${student.grade}" />
			</p>
			<p class="mb-5 text-white text-lg font-medium">
				Class :
				<c:out value="${student.className}" />
			</p>
			
			<div class="flex flex-col flex-wrap space-y-3">
			  <a href="ShowUpdateProfileInfo"><button class="bg-indigo-600 text-white focus:outline-none hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-1 px-2 rounded-3xl">Update Profile</button></a>
			  <a href="ShowEditFormPassword"> <button class="bg-indigo-600 text-white focus:outline-none hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-1 px-2 rounded-3xl">Reset Password</button></a>
			</div>
			
		</aside>
	</section>
</body>
</html>

