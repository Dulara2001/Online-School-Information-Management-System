<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
<link rel="stylesheet" href="./css/global.css" />
<title>Student | Support Desk</title>
</head>
<body class="min-h-screen">
	
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
				Support Desk
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
	
	<!-- Welcome message -->
	<section class="mx-2 sm:mx-3 md:mx-4 flex flex-col items-center">
		<div class="w-full text-white bg-gray-900 bg-opacity-80 p-4 rounded-3xl shadow-2xl max-w-4xl mb-4 flex flex-col items-center">
		  <p class="text-4xl md:text-5xl font-semibold text-indigo-400 mb-3">HELLO!</p>
		  <p class="text-lg font-medium">Post your questions here!</p>
		</div>

	<!-- Support desk form -->
	
		<form action="addInquiry" method="post" class="w-full text-white bg-gray-900 bg-opacity-80 p-4 rounded-3xl shadow-2xl flex flex-col max-w-4xl mb-5">
		  <label for="email" class="block mb-2">Email</label>
		  <input placeholder="Enter your email" required class="text-gray-900 py-2 px-3 focus:outline-none rounded-2xl shadow-2xl mb-4" type="email" name="email" />
		
		  <label for="tilte" class="block mb-2">Title</label>
		  <input placeholder="Enter the inquiry title here" required class="text-gray-900 py-2 px-3 focus:outline-none rounded-2xl shadow-2xl mb-4" type="text" name="title" />
		
		  <label for="inquiry" class="block mb-2">Inquiry</label>
		  <textarea placeholder="Enter the message here" required class="text-gray-900 py-2 px-3 focus:outline-none rounded-2xl shadow-2xl mb-5" name="inquiry"></textarea>
		  <div class="flex justify-center">
		    <button type="submit" class="bg-indigo-600 py-2 px-4 hover:bg-indigo-500 transition ease-in focus:outline-none ring-2 ring-offset-transparent ring-gray-50 rounded-2xl shadow-2xl">Submit</button>
		  </div>
		</form>
	</section>
	

</body>
</html>