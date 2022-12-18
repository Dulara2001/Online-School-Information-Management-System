<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
	<link rel="stylesheet" href="./css/global.css" />
<title>Teacher | Add notices</title>
</head>
<body class="min-h-screen">

	<%
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	
	<%
	String userState = (String) session.getAttribute("userState");
	%>
	
	<c:set var="userState" scope="session" value="<%=userState%>" />

	<header>
		<div class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
			<h1 class="font-bold text-3xl">SIMS</h1>
			<form action="Logout">
				<button type="submit" class="bg-indigo-600 py-2 px-5 text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
			</form>
		</div>
	    <div class="md:px-4 px-2 mb-7">
			<h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">
				Add Notices
			</h2>
			<nav class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
				<div class="mb-3">
					<h4 class="text-white">
							<span class="capitalize"><%=userState%></span> info | <a
								class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl"
								href="Profile">Profile</a>
					</h4>
				</div>
			
			</nav>
	    </div>
	</header>
	
	<!-- Add notices form -->
	<div class="flex flex-col justify-center items-center md:mx-4 sm:mx-3 mx-2">
	    <form class="bg-gray-900 bg-opacity-80 text-white w-full max-w-xl p-5 rounded-2xl shadow-2xl flex flex-col justify-center mb-5" method="post" action="AddNotices">
	      <h3 class="text-white text-center font-semibold text-2xl md:text-3xl mb-4">Add Notices here</h3>
	
	      <label class="font-medium mb-2" for="date">Date</label>
	      <input placeholder="Enter the date" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400 mb-3" type="date" name="date" />
	
	      <label class="font-medium mb-2" for="title">Title</label>
	      <input placeholder="Title of the notice" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400 mb-3" type="text" name="title" />
	
	      <label class="font-medium mb-2" for="description">Description</label>
	      <textarea placeholder="Body of the notice" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400 mb-3" type="text" name="description"></textarea>
	
	      <label class="font-medium mb-2" for="type">Type</label>
	      <div class="flex flex-row space-y-2 justify-between w-40 mb-1">
	        <label>Student</label>
	        <input type="checkbox" name="type" value="student" />
	      </div>
	      <div class="flex flex-row space-y-2 justify-between w-40 mb-5">
	        <label>Academic</label>
	        <input type="checkbox" name="type" value="academic" />
	      </div>
	
	      <div class="flex justify justify-center">
	        <button type="submit" class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 focus:outline-none text-white rounded-2xl shadow-2xl py-2 px-6 mb-3">Submit</button>
	      </div>
	    </form>
  	</div>
	
</body>
</html>