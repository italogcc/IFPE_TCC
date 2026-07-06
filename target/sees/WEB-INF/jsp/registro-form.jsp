<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro</title>
</head>
<body>

<h2>Cadastro de usuário - ${tipo}</h2>

<c:if test="${not empty erro}">
    <p style="color:red;">${erro}</p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/registrar">

    <input type="hidden" name="tipo" value="${tipo}">

    <h3>Dados de acesso</h3>

    <label>E-mail:</label><br>
    <input type="email" name="email" required><br><br>

    <label>Senha:</label><br>
    <input type="password" name="senha" required><br><br>

    <c:if test="${tipo == 'PF' || tipo == 'A'}">
        <h3>Dados de Pessoa Física</h3>

        <label>Nome:</label><br>
        <input type="text" name="nome" required><br><br>

        <label>Sobrenome:</label><br>
        <input type="text" name="sobrenome" required><br><br>

        <label>CPF:</label><br>
        <input type="text" name="cpf" required><br><br>

        <label>RG:</label><br>
        <input type="text" name="rg"><br><br>

        <label>Data de nascimento:</label><br>
        <input type="date" name="dataNascimento"><br><br>
    </c:if>

    <c:if test="${tipo == 'PJ' || tipo == 'F'}">
        <h3>Dados de Pessoa Jurídica</h3>

        <label>Razão Social:</label><br>
        <input type="text" name="razaoSocial" required><br><br>

        <label>Nome Fantasia:</label><br>
        <input type="text" name="nomeFantasia"><br><br>

        <label>CNPJ:</label><br>
        <input type="text" name="cnpj" required><br><br>

        <label>Inscrição Estadual:</label><br>
        <input type="text" name="inscricaoEstadual"><br><br>
    </c:if>

    <h3>Endereço e contato</h3>

    <label>Logradouro:</label><br>
    <input type="text" name="logradouro"><br><br>

    <label>Número:</label><br>
    <input type="text" name="logNumero"><br><br>

    <label>Complemento:</label><br>
    <input type="text" name="complemento"><br><br>

    <label>Cidade:</label><br>
    <input type="text" name="cidade"><br><br>

    <label>Estado:</label><br>
    <input type="text" name="estado" maxlength="2"><br><br>

    <label>CEP:</label><br>
    <input type="text" name="cep"><br><br>

    <label>Telefone 1:</label><br>
    <input type="text" name="telefone1"><br><br>

    <label>Telefone 2:</label><br>
    <input type="text" name="telefone2"><br><br>

    <button type="submit">Cadastrar</button>

</form>

</body>
</html>
