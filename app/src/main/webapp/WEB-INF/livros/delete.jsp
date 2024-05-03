<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Remover Livros</title>
    </head>
    <body>
        <h1>Remover Livros</h1>
        <p>
            Tem certeza que deseja excluir o livro ${livro.getTitulo()} ?
        </p>
        <form action='/livros/delete' method='post'>
            <input type="hidden" name="id" value="${livro.getId()}"/>
            <button type="submit">Excluir</button>
        </form>
    </body>
</html>
