<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Gêneros</title>
    </head>
    <body>
        <h1>Gêneros</h1>
        <a href="/generos/insert">Novo Gênero</a>
        <table>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach var="g" items="${generos}">
                <tr>
                    <td>${g.id}</td>
                    <td>${g.nome}</td>
                    <td>
                        <a href="/generos/update/${g.id}">Editar</a> | 
                        <a href="/generos/delete/${g.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

