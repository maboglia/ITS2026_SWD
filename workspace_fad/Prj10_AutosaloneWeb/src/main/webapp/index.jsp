<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="model.Veicolo"%>
<html>
<head>
<meta charset="UTF-8">
<title>Autosalone</title>
</head>
<body>

	<div class="container">
	
		<h1>Autosalone</h1>
	
		<%
			Veicolo v = new Veicolo("Moto da strada");
		
			List<Veicolo> veicoli = 
					List.of(v, new Veicolo("Auto topp"));			

		
		%>
		
		<% for (var x : veicoli){ %>
		
			<h2><%= x %></h2>
		
		<% } %>
	
	
	</div>

</body>
</html>