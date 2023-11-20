<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Canto do artesão</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2 class="mt-5 mb-4">Cadastro de Produtos</h2>
        
        <form name="frmProduto" action="insert">
            <div class="form-group">
                <label for="nomeProduto">Nome do Produto:</label>
                <input type="text" class="form-control" id="idProduto" readonly value="<%out.print(request.getAttribute("idProduto")); %>" name="idProduto" required>
            </div>
            
            <div class="form-group">
                <label for="nomeProduto">Nome do Produto:</label>
                <input type="text" class="form-control" id="nomeProduto" value="<%out.print(request.getAttribute("nomeProduto")); %>" name="nomeProduto" required>
            </div>

            <div class="form-group">
                <label for="descricao">Descrição:</label>
                <input class="form-control" id="descricao"  name="descricao" value="<%out.print(request.getAttribute("descricao")); %>" required>
            </div>
			
			<div class="form-group">
                <label for="preco">Preço:</label>
                <input class="form-control" id="preco"  name="preco" value="<%out.print(request.getAttribute("preco")); %>"  required>
            </div>	
            
            <div class="form-group">
                <label for="quantidadeEstoque">Quantidade em Estoque:</label>
                <input type="number" class="form-control" id="quantidadeEstoque"   name="quantidadeEstoque" value="<%out.print(request.getAttribute("quantidadeEstoque")); %>" required>
            </div>

            <input type="button" value="Salvar"class="Botao1" onclick="validar()">
        </form>
			<script src ="scripts/validador.js"></script>
        
    </div>
</body>
</html>


