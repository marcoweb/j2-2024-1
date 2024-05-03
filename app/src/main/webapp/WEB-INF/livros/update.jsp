<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Editar Livros</title>
    </head>
    <body>
        <h1>Editar Livros</h1>
        <form action='/livros/update' method='post'>
            <input type="hidden" name="id" value="${livro.getId()}">
            <div>
                <label>Título</label>
                <input type="text" name="titulo" value="${livro.getTitulo()}">
            </div>
            <div>
                <label>Gênero</label>
                <input type="text" name="genero" value="${livro.getGenero()}">
            </div>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>
