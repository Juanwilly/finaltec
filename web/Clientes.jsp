<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-3" style="margin-right: 10px">
            <div class="card-body">
                <form action="controlador?menu=Cliente" method="POST">
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" value="${cliente.getDni()}" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Nombres</label>
                        <input type="text" value="${cliente.getNombres()}" name="txtNombres" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Direccion</label>
                        <input type="text" value="${cliente.getDireccion()}" name="txtDireccion" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input placeholder="1 si esta activo 2 si no" type="text" value="${cliente.getEstado()}" name="txtEstado" class="form-control">
                    </div>
                    <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                    <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                </form>
            </div>
        </div>
        <div class="col-7">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DNI</th>
                        <th>NOMBRES</th>
                        <th>DIRECCION</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="cl" items="${clientes}">
                    <tr>
                        <td>${cl.getIdCliente()}</td>
                        <td>${cl.getDni()}</td>
                        <td>${cl.getNombres()}</td>
                        <td>${cl.getDireccion()}</td>
                        <td>${cl.getEstado()}</td>
                        <td class="d-flex">
                            <a class="btn btn-warning" href="controlador?menu=Cliente&accion=EditarCliente&id=${cl.getIdCliente()}">Editar</a>
                            &nbsp;
                            <a class="btn btn-danger" href="controlador?menu=Cliente&accion=DeleteCliente&id=${cl.getIdCliente()}">Delete</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
    
</html>
