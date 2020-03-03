<%-- 
    Document   : RegistroCliente
    Created on : 3/03/2020, 04:28:14 PM
    Author     : B09S105est
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <title>Administracion de Clientes</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
    <body>
       <div class="container">
            <h1>Registro de Clientes</h1>
            <form method="post" action="<%= request.getContextPath() %>/RegistroClienteServlet">
                <div class="form-group">
                    <label for="IdentCliente">
                        Identificacion del Cliente:   
                    </label>
                    <input id="IdentCliente" class="form-control" name="IdentCliente" type="text" placeholder="Escriba la identificacion del cliente" required="true">
                </div>
                <div class="form-group">
                    <label for="NombreCliente">
                        Nombre del Cliente   
                    </label>
                    <input id="NombreCliente" class="form-control" name="NombreCliente" type="text" placeholder="Escriba el nombre del cliente" required="true">
                </div>
                <div class="form-group">
                    <label for="Telefono">
                        Telefono del Cliente   
                    </label>
                    <input id="Telefono" class="form-control" name="Telefono" type="text" placeholder="Escriba el telefono del cliente" required="true">
                </div>
                <div class="form-group">
                    <label for="Email">
                        Email del Cliente   
                    </label>
                    <input id="Email" class="form-control" name="Email" type="text" placeholder="Escriba el email del cliente" required="true">
                </div>
                <div>
                    <input type="submit" value="Registrar" class="btn btn-primary">
                </div>
            </form>
        </div>
    </body>
</html>
