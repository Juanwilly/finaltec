<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        <style>
            @media print{
                .parte01, .parte02, .btn, .accion{
                    display: none;
                } 
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-6 parte01">
                <div class="card">
                    <form action="controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="text" name="codigocliente" value="${c.getDni()}" class="form-control" placeholder="Codigo">
                                    &nbsp;
                                    <input type="submit" name="accion" value="BuscarCliente" class="btn btn-outline-info">
                                    &nbsp;
                                </div>
                                <div class="col-sm-7">
                                    <input type="text" name="nombrescliente" value="${c.getNombres()}" class="form-control">
                                </div>
                            </div>
                            <br>
                            <!-- Datos Del PRODUCTO -->
                            <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group">
                                <div class="form-group d-flex">
                                    <div class="col-sm-4 d-flex">
                                        <input type="text" name="codigoproducto" class="form-control" placeholder="Codigo">
                                        &nbsp; 
                                        <button class="btn btn-outline-info" value="BuscarProducto" name="accion" type="submit">
                                            <img src="folder/mano.png" alt="20" width="50"/>
                                            </button>
                                        &nbsp;
                                    </div>
                                    <div class="col-sm-7">
                                        <input type="text" name="nomproducto" value="${producto.getNombres()}" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <br>
                            
                            <div class="form-group">
                                <label>Informacion Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-3">
                                    <input type="text" name="precio" class="form-control" placeholder="$" value="${producto.getPrecio()}">
                                </div>
                                &nbsp;
                                <div class="col-sm-3">
                                    <input type="number" name="cant" class="form-control" value="1">
                                </div>
                                &nbsp;
                                <div class="col-sm-3">
                                    <input type="text" name="stock" class="form-control" value="${producto.getStock()}">
                                </div>
                            </div>
                            <br>
                            <div class="form-group">
                                <button class="btn btn-outline-info" value="Agregar" name="accion" type="submit">
                                    <img src="folder/NuevaVEnta.png" alt="30" width="30"/>
                                    Agregar Producto</button>
                            </div>
                            <br>
                        </div>
                </div>
                </form>
            </div>
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-5 ml-right">
                            <label>Nro de Serie:</label>
                            <input type="text" name="NroSerie" value="${nserie}" class="form-control" disabled="true">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>CODIGO</th>
                                    <th>DESCRIPCION</th>
                                    <th>PRECIO</th>
                                    <th>CANTIDAD</th>
                                    <th>SUBTOTAL</th>
                                    <th class='accion'>ACCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getItem()}</td>
                                    <td>${list.getIdproducto()}</td>
                                    <td>${list.getDescripcionP()}</td>
                                    <td>${list.getPrecio()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>${list.getSubtotal()}</td>
                                    <td>
                                        <a href="controlador?menu=NuevaVenta&accion=Eliminar&id=${list.getItem()}" class="btn btn-danger">Eliminar</a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6 parte02">
                            <a href="controlador?menu=NuevaVenta&accion=GenerarVenta"  class="btn btn-dark">Generar Venta</a>
                             <div
                                <a href="controlador?menu=NuevaVenta&accion=Cancelar" class="btn btn-warning">Cancelar</a>
                             </div>
                            <div>
                              <a href="controlador?menu=NuevaVenta&accion=GenerarVenta" onclick="print()" class="btn btn-dark">
                                  <img src="folder/impresora.jpeg" alt="70" width="70"/>
                              </a>  
                            </div>
                        </div>
                        <div col-sm-3 ml-auto>
                            <input type="text" name="txtTotal" class="form-control" value="$ ${totalpagar}" disabled="true">
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</html>
