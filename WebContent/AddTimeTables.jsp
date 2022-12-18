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
<title>Teacher | Add timetables</title>
</head>
<body class="min-h-screen">

	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>

	<header>
		<div class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
			<h1 class="font-bold text-3xl">SIMS</h1>
			<form action="Logout">
				<button type="submit" class="bg-indigo-600 py-2 px-5 text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
			</form>
		</div>
    <div class="md:px-4 px-2 mb-7">
		<h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">
			Welcome
			<c:out value="${teacher.name}" />
		</h2>
		<nav class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
			<div class="mb-3">
				<h4 class="text-white">
						Teacher info | <a
							class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl"
							href="Profile">Profile</a>
				</h4>
			</div>
			
		</nav>
    </div>
	</header>

	<!-- Add timetables form -->
	<div class="flex justify-center md:mx-4 sm:mx-3 mx-2">
	    <div class="bg-gray-900 bg-opacity-80 text-white rounded-2xl shadow-2xl w-full max-w-xl p-5 mb-5">
	      <c:if test="${timetable != null}">
		      <h2 class="font-medium text-center md:text-4xl sm:text-3xl text-2xl">Update timetable</h2>
		      <form class="flex flex-col" method="post" action="UpdateTimetable" enctype="multipart/form-data">
		        <label class="font-medium mb-2" for="year">Year</label>
		        <input class="py-2 px-3 text-gray-900 rounded-3xl shadow-2xl focus:ring-2 focus:ring-indigo-500 focus:ring-offset-indigo-500 focus:outline-none mb-3" type="text" name="year" value="<c:out value="${timetable.year}" />">
		        <label class="font-medium mb-2" for="grade">Grade</label>
		        <input class="py-2 px-3 text-gray-900 rounded-3xl shadow-2xl focus:ring-2 focus:ring-indigo-500 focus:ring-offset-indigo-500 focus:outline-none mb-3" type="text" name="grade" value="<c:out value="${timetable.grade}" />">
		        <label class="font-medium mb-2" for="class">Class</label>
		        <input class="py-2 px-3 text-gray-900 rounded-3xl shadow-2xl focus:ring-2 focus:ring-indigo-500 focus:ring-offset-indigo-500 focus:outline-none mb-3" type="text" name="class" value="<c:out value="${timetable.className}" />">
		        <label class="font-medium mb-3" for="file">Image</label>
		        <div class="overflow-hidden relative w-64 mb-5">
		          <input class="cursor-pointer z-40 block absolute opacity-0 pin-r pin-t p-2" type="file" name="file" size="50" />
		          <button class="bg-indigo-600 hover:bg-indigo-500 z-20 cursor-pointer transition ease-in rounded-3xl shadow-2xl text-white py-2 px-4 w-full inline-flex items-center">
		            <svg fill="#FFF" height="18" viewBox="0 0 24 24" width="18" xmlns="http://www.w3.org/2000/svg">
		              <path d="M0 0h24v24H0z" fill="none" />
		              <path d="M9 16h6v-6h4l-7-7-7 7h4zm-4 2h14v2H5z" />
		            </svg>
		            <span class="ml-2">Upload Timetable</span>
		          </button>
	        	</div>
		        <div class="flex justify-center">
		          <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-6 rounded-3xl" type="submit">Submit</button>
		        </div>
		      </form>
	      </c:if>
	
	      <c:if test="${timetable == null}">
		      <h2 class="font-medium text-center md:text-4xl sm:text-3xl text-2xl">Add timetable</h2>
		      <form class="flex flex-col" method="post" action="AddTimetables" enctype="multipart/form-data">
		        <label class="font-medium mb-2" for="year">Year</label>
		        <input placeholder="Timetable year" class="py-2 px-3 text-gray-900 rounded-3xl shadow-2xl focus:ring-2 focus:ring-indigo-500 focus:ring-offset-indigo-500 focus:outline-none mb-3" type="text" name="year" />
		        <label class="font-medium mb-2" for="grade">Grade</label>
		        <input placeholder="Timetable grade" class="py-2 px-3 text-gray-900 rounded-3xl shadow-2xl focus:ring-2 focus:ring-indigo-500 focus:ring-offset-indigo-500 focus:outline-none mb-3" type="text" name="grade" />
		        <label class="font-medium mb-2" for="class">Class</label>
		        <input placeholder="Timetable class" class="py-2 px-3 text-gray-900 rounded-3xl shadow-2xl focus:ring-2 focus:ring-indigo-500 focus:ring-offset-indigo-500 focus:outline-none mb-3" type="text" name="class" />
		        <label class="font-medium mb-3" for="file">Image</label>
		        <div class="overflow-hidden relative w-64 mb-5">
		          <input class="cursor-pointer z-40 block absolute opacity-0 pin-r pin-t p-2" type="file" name="file" size="50" />
		          <button class="bg-indigo-600 hover:bg-indigo-500 z-20 cursor-pointer transition ease-in rounded-3xl shadow-2xl text-white py-2 px-4 w-full inline-flex items-center">
		            <svg fill="#FFF" height="18" viewBox="0 0 24 24" width="18" xmlns="http://www.w3.org/2000/svg">
		              <path d="M0 0h24v24H0z" fill="none" />
		              <path d="M9 16h6v-6h4l-7-7-7 7h4zm-4 2h14v2H5z" />
		            </svg>
		            <span class="ml-2">Upload Timetable</span>
		          </button>
	        	</div>
		        <div class="flex justify-center">
		          <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-6 rounded-3xl" type="submit">Submit</button>
		        </div>
		      </form>
	      </c:if>
	    </div>
  	</div>

</body>
</html>