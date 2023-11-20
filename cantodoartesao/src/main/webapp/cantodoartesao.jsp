<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
 @ SuppressWarnings("uncheked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Canto do artesão</title>
<link rel="icon" href="imagens/handcraft.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Canto do artesão</h1>
	<a href="novo.html" class="Botao1">Produtos</a>
	<a href="report" class="Botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th colspan="2">ID</th>
				<th colspan="2">Nome do produto</th>
				<th colspan="2">Descrição</th>
				<th colspan="2">Preço</th>
				<th colspan="2">Quantidade em Estoque</th>
				<th colspan="2">Opções</th>
			</tr>
		</thead>
		<tbody>
				<%
				for (int i = 0; i < lista.size(); i++) {
				%>
				<tr>
					<td colspan="2"><%=lista.get(i).getIdProduto()%></td>
					<td colspan="2"><%=lista.get(i).getNomeProduto()%></td>
					<td colspan="2"><%=lista.get(i).getDescricao()%></td>
					<td colspan="2"><%=lista.get(i).getPreco()%></td>
					<td colspan="2"><%=lista.get(i).getQuantidadeEstoque()%></td>
					<td colspan="2"><a href="select?idProduto=<%=lista.get(i).getIdProduto()%>"
						class="Botao2">Editar</a><a
						href="javascript: confirmar(<%=lista.get(i).getIdProduto()%>) "
						class="Botao1">Excluir</a></td>
				</tr>
				<%}%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>