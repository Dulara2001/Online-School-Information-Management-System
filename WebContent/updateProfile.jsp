<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
<link rel="stylesheet" href="./css/global.css" />
<title>Update Profile | SIMS</title>
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
				Update Profile
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
	    <h3 class="font-semibold text-2xl md:text-3xl mb-4">Update your profile</h3>
	    <form class="flex flex-col" action="UpdateProfile" method="post">
	      <label class="mb-2" for="uname"> User Name</label>
	      <input class="text-gray-900 py-2 px-3 rounded-2xl shadow-2xl mb-3" type="text" name="uname" value="${auth.userName}" />
	
	      <label class="mb-2" for="name"> Name</label>
	      <input class="text-gray-900 py-2 px-3 rounded-2xl shadow-2xl mb-3" type="text" name="name" value="${student.name}" />
	
	      <label class="mb-2" for="age"> Age</label>
	      <input class="text-gray-900 py-2 px-3 rounded-2xl shadow-2xl mb-3" type="text" name="age" value="${student.age}" readonly />
	
	      <label class="mb-2" for="address"> Address </label>
	      <input class="text-gray-900 py-2 px-3 rounded-2xl shadow-2xl mb-3" type="text" name="address" value="${student.address}" />
	
	      <label class="mb-2" for="contact"> Contact No </label>
	      <input class="text-gray-900 py-2 px-3 rounded-2xl shadow-2xl mb-5" type="text" name="contact" value="${student.contact}" />
	
	      <button type="submit" class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-3 rounded-3xl mb-4">Submit</button>
	    </form>
	  </div>
	</div>


</body>
</html>