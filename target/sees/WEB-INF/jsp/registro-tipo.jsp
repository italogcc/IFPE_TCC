<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Registrar usuário</title>
</head>
<body>

<h2>Qual tipo de usuário deseja registrar?</h2>

<ul>
    <li>
        <a href="${pageContext.request.contextPath}/registrar/formulario?tipo=PF">Pessoa Física
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/registrar/formulario?tipo=PJ">Pessoa Jurídica
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/registrar/formulario?tipo=F">Fornecedor
        </a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/registrar/formulario?tipo=A">Administrador do Sistema
        </a>
    </li>
</ul>

</body>
</html>
