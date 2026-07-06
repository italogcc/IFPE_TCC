<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Painel</title>
</head>
<body>

<h2>Bom dia ${nome}</h2>

<c:if test="${temFaturas == false}">
    <p>Você ainda não possui faturas de energia cadastradas.</p>
    <p>Deseja cadastrar suas 12 faturas agora?</p>

    <a href="${pageContext.request.contextPath}/faturas/novo">
        Cadastrar faturas de energia
    </a>
</c:if>

<c:if test="${temFaturas == true}">
    <p>Suas faturas já foram cadastradas.</p>
</c:if>

</body>
</html>
