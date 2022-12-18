<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
	<link href="./css/global.css" rel="stylesheet" />
<title>Enrollments | SIMS</title>
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
			<h1 class="font-bold text-3xl">SIMS</h1>
			<form action="Logout">
				<button type="submit"
					class="bg-indigo-600 py-2 px-5 text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
			</form>
		</div>
		<div class="md:px-4 px-2 mb-7">
			<h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">
				Enrollments
			</h2>
			<nav
				class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
				<div class="mb-3">
					<h4 class="text-white">
						Admin info | <a
							class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl"
							href="Profile">Profile</a>
					</h4>
				</div>
				
			</nav>
		</div>
	</header>
	<br><br><br>
	<section class="flex justify-center items-center flex-wrap md:mx-4 sm:mx-3 mx-2">
	    <div class="flex flex-col items-center bg-gray-500 bg-opacity-95 p-5 w-80 h-54 rounded-2xl shadow-2xl m-3">
	      <h3 class="text-gray-900 text-center text-xl font-medium mb-3">Student Enrollments</h3><br>
	      <a href="addStudent.jsp">
	        <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in focus:outline-none ring-2 ring-gray-400 py-2 px-3 rounded-3xl">Enroll Now</button>
	      </a>
	    </div>
	
	    <div class="flex flex-col items-center bg-gray-500 bg-opacity-95 p-5 w-80 h-54 rounded-2xl shadow-2xl m-3">
	      <h3 class="text-gray-900 text-center text-xl font-medium mb-3">Staff Enrollments</h3><br>
	      <a href="addTeacher.jsp">
	        <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in focus:outline-none ring-2 ring-gray-400 py-2 px-3 rounded-3xl">Enroll Now</button>
	      </a>
	    </div>
  	</section>
	
</body>
</html>