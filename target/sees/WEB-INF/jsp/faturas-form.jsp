<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Faturas</title>
</head>
<body>

<h2>Cadastro de 12 Faturas de Energia</h2>

<form method="post" action="${pageContext.request.contextPath}/faturas/salvar">

    <table border="1" cellpadding="8">
        <thead>
        <tr>
            <th>#</th>
            <th>Mês/Ano</th>
            <th>Consumo em kWh</th>
            <th>Valor Pago R$</th>
        </tr>
        </thead>

        <tbody>
        <% for (int i = 1; i <= 12; i++) { %>
            <tr>
                <td><%= i %></td>
                <td>
                    <input type="month" name="mesAno" required>
                </td>
                <td>
                    <input type="number" name="kwh" step="0.01" min="0" required>
                </td>
                <td>
                    <input type="number" name="valorPago" step="0.01" min="0" required>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
    <br>
    <button type="submit">Salvar faturas</button>

</form>

</body>
</html>
