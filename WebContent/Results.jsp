<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
    <link href="./css/global.css" rel="stylesheet"/>
    <title>Results | SIMS</title>
  </head>
  <body class="h-screen">
    <header>
      <div class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
        <h1 class="font-bold text-3xl">SIMS</h1>
        <form action="Logout">
          <button type="submit" class="bg-indigo-600 py-2 px-5 rounded-3xl text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
        </form>
      </div>
      <div class="md:px-4 px-2 mb-8">
        <h2 class="text-white font-bold md:text-5xl sm:text-left text-center sm:text-4xl text-3xl mb-6">Results</h2>
        <nav class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
          <div class="text-white mb-3">
            <h4>Student info | <a class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl" href="Profile">Profile</a></h4>
          </div>
          <div class="my-4 ml-2 space-x-2">
            <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl"><a href="Results.jsp">Results</a></button>
            <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in mb-1 ring-2 ring-gray-400 py-2 px-3 rounded-3xl"><a href="SupportDesk.jsp">Support</a></button>
          </div>
        </nav>
      </div>
    </header>

    <!-- Search result form -->

    <section class="px-2 md:px-4">
      <h4 class="text-white font-medium text-lg mb-4">Select the relavant fiels to get the results</h4>

      <form action="viewResult" method="post" class="max-w-4xl bg-gray-500 bg-opacity-95 p-4 rounded-2xl">
        <div class="mb-3">
          <label for="exam" class="mr-3 font-medium text-white"> Examination : </label>
          <select name="exam" class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 p-1 rounded-2xl focus:outline-none">
            <option class="bg-indigo-500 text-white p-1" value="Term1">Term 1</option>
            <option class="bg-indigo-500 text-white p-1" value="Term2">Term 2</option>
            <option class="bg-indigo-500 text-white p-1" value="Term3">Term 3</option>
          </select>
        </div>
        <div class="mb-3">
          <label for="year" class="mr-3 font-medium text-white"> Year :</label>
          <select class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 p-1 rounded-2xl focus:outline-none" name="year">
            <option class="bg-indigo-500 text-white p-1" value="2021">2022</option>
            <option class="bg-indigo-500 text-white p-1" value="2020">2021</option>
            <option class="bg-indigo-500 text-white p-1" value="2019">2020</option>
            <option class="bg-indigo-500 text-white p-1" value="2018">2019</option>
          </select>
        </div>
        <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-1 px-4 rounded-3xl" type="submit">Check</button>
      </form>
    </section>
  </body>
</html>
