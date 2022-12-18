<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Exam Result</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet" />
    <link href="./css/global.css" rel="stylesheet" />
  </head>
  <body class="h-screen">
    <header>
      <div class="w-full flex justify-between items-center p-4 mb-3 bg-gray-800 text-white">
        <h1 class="font-bold text-3xl">SIMS</h1>
        <form action="Logout">
          <button type="submit" class="bg-indigo-600 py-2 px-5 rounded-3xl text-base hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400">Logout</button>
        </form>
      </div>
      <div class="md:px-4 px-2 mb-7">
        <h2 class="text-white sm:text-left text-center font-bold md:text-5xl sm:text-4xl text-3xl mb-6">Results</h2>
        <nav class="flex sm:justify-between justify-center items-center flex-wrap text-lg font-medium">
          <div class="mb-3">
            <h4 class="text-white">Student info | <a class="bg-indigo-600 hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 py-2 px-5 rounded-3xl" href="Profile">Profile</a></h4>
          </div>
          <div class="my-4 ml-2 space-x-3 flex justify-center">
            <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
              <a href="Results.jsp">Results</a>
            <button class="bg-indigo-600 text-white hover:bg-indigo-500 transition ease-in ring-2 ring-gray-400 mb-1 py-2 px-3 rounded-3xl">
              <a href="SupportDesk.jsp">Support</a>
            </button>
          </div>
        </nav>
      </div>
    </header>

  	<section class="bg-gray-500 bg-opacity-95 max-w-4xl md:px-4 px-2 py-5 md:mx-4 mx-2 rounded-2xl shadow-2xl">
	  <h4 class="text-white font-medium text-lg text-center sm:text-left mb-3">Examination Results</h4>
	  <div class="flex justify-center sm:justify-start flex-wrap">
	    <c:forEach var="item" items="${marks}">
	      <c:if test="${item.result >= 75}">
	        <c:set var="color" scope="session" value="bg-green-500" />
	      </c:if>
	      <c:if test="${item.result >= 40 && item.result < 75}">
	        <c:set var="color" scope="session" value="bg-yellow-500" />
	      </c:if>
	      <c:if test="${item.result >= 0 && item.result < 40}">
	        <c:set var="color" scope="session" value="bg-red-500" />
	      </c:if>
	      <div class="flex flex-col justify-center text-white font-medium text-center ${color} sm:m-3 m-2 sm:h-40 sm:w-40 h-36 w-36 rounded-2xl shadow-2xl">
	        <h4 class="sm:text-2xl text-xl"><c:out value="${item.sub}" /></h4>
	        <div class="sm:text-lg"><c:out value="${item.result}" /></div>
	      </div>
	    </c:forEach>
	  </div>
	</section>

  </body>
</html>