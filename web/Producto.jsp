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
        <title>Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    </head>
    <body>
        <div class="d-flex">
            <div class="card col-3" style="margin-right: 10px">
            <div class="card-body">
                <form action="controlador?menu=Producto" method="POST">
                    <div class="form-group">
                        <label>Nombre Producto</label>
                        <input type="text" value="${producto.getNombres()}" name="txtNombre" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Precio</label>
                        <input type="number" value="${producto.getPrecio()}" name="txtPrecio" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Stock</label>
                        <input type="number" value="${producto.getStock()}" name="txtStock" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>Estado</label>
                        <input placeholder="1 si esta activo 2 si no" type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
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
                        <th>NOMBRE PRODUCTO</th>
                        <th>PRECIO</th>
                        <th>STOCK</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="prod" items="${productos}">
                    <tr>
                        <td>${prod.getIdProducto()}</td>
                        <td>${prod.getNombres()}</td>
                        <td>${prod.getPrecio()}</td>
                        <td>${prod.getStock()}</td>
                        <td>${prod.getEstado()}</td>
                        <td class="d-flex">
                            <a class="btn btn-warning" href="controlador?menu=Producto&accion=EditarProducto&id=${prod.getIdProducto()}">Editar</a>
                            &nbsp;
                            <a class="btn btn-danger" href="controlador?menu=Producto&accion=DeleteProducto&id=${prod.getIdProducto()}">Delete</a></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>
    
</html>
