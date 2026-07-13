<%@page import="java.util.List"%>
<%@page import="entities.Prodotto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
  rel="stylesheet"
  href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
>
</head>
<body>
	<div class="container">
	
		<h1><%= request.getAttribute("titolo") %></h1>

		<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Prezzo</th>
			</tr>
		</thead>
			<tbody>
				<% for (Prodotto p : (List<Prodotto>) request.getAttribute("prodotti")){ %>
				<tr>
					<td><%=p.nome()%></td>
					<td><a href="?categoria=<%=p.categoria()%>"><%=p.categoria()%></a></td>
					<td><%=p.prezzoKg()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	</div>

</body>
</html>