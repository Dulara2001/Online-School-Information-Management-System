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
<title>Reset Password | GISMS</title>
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
				Reset Password
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
				
			</nav>
		</div>
	</header>

	<div class="flex justify-center">
	  <div class="p-5 text-white bg-gray-800 bg-opacity-80 rounded-2xl shadow-2xl w-full max-w-3xl flex flex-col items-center">
	    <h3 class="font-semibold text-2xl md:text-3xl mb-4">Reset your password</h3>
	    <form class="flex flex-col" action="ResetPassword" method="post">
	      <label class="mb-2" for="uname"> User Name</label>
	      <input class="text-gray-900 focus:outline-none py-2 px-3 rounded-2xl shadow-2xl mb-3" type="text" name="uname" value="${user.userName}" readonly />
	
	      <label class="mb-2" for="pwd"> Password </label>
	      <input class="text-gray-900 focus:outline-none py-2 px-3 rounded-2xl shadow-2xl mb-3" type="password" name="pwd" placeholder="Your current password" required />
	
	      <label class="mb-2" for="new-pwd"> New Password </label>
	      <input class="text-gray-900 focus:outline-none py-2 px-3 rounded-2xl shadow-2xl mb-5" type="password" name="new-pwd" placeholder="Enter New Password" required />
	
	      <button type="submit" class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-3 rounded-3xl mb-4">Submit</button>
	    </form>
	  </div>
	</div>


</body>
</html>