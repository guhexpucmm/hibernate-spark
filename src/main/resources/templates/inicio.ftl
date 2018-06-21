<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Inicio</title>
</head>
<body>
<h1>USUARIOS</h1>
<table>
    <thead>
        <th>Usuario</th>
        <th>Clave</th>
    </thead>
    <tbody>
        <#list usuarios as usuario>
            <tr>
                <td>${usuario.getUsername()}</td>
                <td>${usuario.getPassword()}</td>
            </tr>
        </#list>
    </tbody>
</table>
</body>
</html>