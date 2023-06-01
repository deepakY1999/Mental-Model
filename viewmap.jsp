<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

                <titel>TODOER</titel>

           <h1>What do you want to do today?</h1>
    
</head>

<style>
.solid{
width:300px;
length:100px
margin:40px 40px 180px;
font-size:20px;
font-family:sans-serif;
boder:6px solid black;
background-color:pink;
outline: 10px solid yellow;
outline-offset:5px;
}

<body>


</style>

<div class="solid">

Learn Coding

</div>

<table table border="2" width="80%" cellpadding="2"> 
<tr><th>Id</th><th>Name</th><th>Salary</th>
<c:forEach var="emp" items=${msg }>

<tr>
<td>${emp.Learn_React }</td>
<td>${emp.Learn_Node }</td>
<td>${emp.Learn_JavaScript_Programming }</td>
</tr>
</c:forEach>

</table>
<br/>
<a href="/TODOER/1">1</a>
<a href="/TODOER/2">2</a>
<a href="/TODOER/3">3</a>



</body>
</html>