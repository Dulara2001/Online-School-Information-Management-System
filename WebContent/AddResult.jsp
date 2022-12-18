<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link href="./css/global.css" rel="stylesheet" />
 <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
<meta charset="ISO-8859-1">
<title>Teacher | Add result</title>
</head>
<body class="min-h-screen">

  	<header>
    <div class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
      <h1 class="font-bold text-3xl">SIMS</h1>
      <form action="Logout">
        <button type="submit" class="bg-indigo-600 py-2 px-5 text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
      </form>
    </div>
    <div class="md:px-4 px-2 mb-7">
      <h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-3xl text-2xl mb-6">Add Results</h2>
      <nav class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
        <div class="mb-3">
          <h4 class="text-white">Teacher info | <a class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl" href="Profile">Profile</a></h4>
        </div>
      </nav>
    </div>
  </header>

  <!-- Add result form -->

  <div class="flex justify-center items-center md:mx-4 sm:mx-3 mx-2">
    <form class="bg-gray-900 bg-opacity-80 text-white p-6 rounded-2xl shadow-2xl mb-5 w-full max-w-xl" action="AddResult" method="post">
    	<h3 class="font-semibold text-lg md:text-2xl mb-4 text-center">Add Student Results here</h3>
      <div class="flex justify justify-between mb-3">
        <label for="subject" class="font-medium"> Subject </label>
        <select name="subject" class="bg-indigo-600 hover:bg-indigo-500 transition ease-in rounded-2xl shadow-2xl py-1 px-3 focus:outline-none" required>
          <option class="font-semibold bg-indigo-500" value="1">ICT</option>
          <option class="font-semibold bg-indigo-500" value="2">English</option>
          <option class="font-semibold bg-indigo-500" value="3">Mathematics</option>
          <option class="font-semibold bg-indigo-500" value="4">Science</option>
          <option class="font-semibold bg-indigo-500" value="5">Sinhala</option>
        </select>
      </div>
      <div class="flex justify justify-between mb-3">
        <label for="exam" class="font-medium text-gray-100"> Examination </label>
        <select name="exam" class="bg-indigo-600 hover:bg-indigo-500 transition ease-in rounded-2xl shadow-2xl py-1 px-3 focus:outline-none" required>
          <option class="font-semibold bg-indigo-500" value="2021Term1">2022 Term 1</option>
          <option class="font-semibold bg-indigo-500" value="2021Term2">2022 Term 2</option>
          <option class="font-semibold bg-indigo-500" value="2021Term3">2022 Term 3</option>
          <option class="font-semibold bg-indigo-500" value="2020Term1">2021 Term 1</option>
          <option class="font-semibold bg-indigo-500" value="2020Term2">2021 Term 2</option>
          <option class="font-semibold bg-indigo-500" value="2021Term2">2021 Term 3</option>
        </select>
      </div>
      <div class="flex justify justify-between mb-3">
        <label for="grade" class="font-medium text-gray-100"> Grade </label>
        <select name="grade" class="bg-indigo-600 hover:bg-indigo-500 transition ease-in rounded-2xl shadow-2xl py-1 px-3 focus:outline-none" required>
          <option class="font-semibold bg-indigo-500" value="6">Grade 6</option>
          <option class="font-semibold bg-indigo-500" value="7">Grade 7</option>
          <option class="font-semibold bg-indigo-500" value="8">Grade 8</option>
          <option class="font-semibold bg-indigo-500" value="9">Grade 9</option>
          <option class="font-semibold bg-indigo-500" value="10">Grade 10</option>
          <option class="font-semibold bg-indigo-500" value="11">Grade 11</option>
          <option class="font-semibold bg-indigo-500" value="12">Grade 12</option>
          <option class="font-semibold bg-indigo-500" value="13">Grade 13</option>
        </select>
      </div>

      <div class="w-full">
        <div class="flex justify justify-between mb-3 font-medium">
          <p>Student ID</p>
          <p>Results</p>
        </div>
        <div class="flex justify-between mb-3 space-x-3">
          <input placeholder="Student ID" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="studentid1" />

          <input placeholder="Student Result" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="result1" />
        </div>
        <div class="flex justify-between mb-3 space-x-3">
          <input placeholder="Student ID" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="studentid2" />

          <input placeholder="Student Result" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="result2" />
        </div>
        <div class="flex justify-between mb-3 space-x-3">
          <input placeholder="Student ID" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="studentid3" />

          <input placeholder="Student Result" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="result3" />
        </div>
        <div class="flex justify-between mb-6 space-x-3">
          <input placeholder="Student ID" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="studentid4" />

          <input placeholder="Student Result" class="w-full p-2 rounded-2xl shadow-2xl text-gray-900 focus:outline-none focus:ring-2 focus:ring-offset-1 focus:ring-offset-indigo-400" type="text" name="result4" />
        </div>
      </div>

      <div class="flex justify justify-center">
        <button type="submit" class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 focus:outline-none text-white rounded-2xl shadow-2xl py-2 px-6">Submit</button>
      </div>
    </form>
  </div>
	
</body>
</html>