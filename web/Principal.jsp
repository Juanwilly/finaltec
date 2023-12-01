<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-info">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="folder/logo-cabecera-blog.jpg" alt="70" width="70"/>
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item active">
                            
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:100px; border: none;" class="btn btn-outline-light" href="controlador?menu=Producto&accion=ListarProducto" target="myFrame">
                                <img src="folder/producto.jpeg" alt="77" width="77"/>
                                <br>Producto</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:100px; border: none;" class="btn btn-outline-light" href="controlador?menu=Empleado&accion=Listar" target="myFrame">
                                <img src="folder/images.jpg" alt="60" width="60"/>
                                <br>Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:100px; border: none;" class="btn btn-outline-light" href="controlador?menu=Cliente&accion=ListarCliente" target="myFrame">
                                <img src="folder/download.png" alt="70" width="70"/>
                                <br>Cliente</a>
                        </li>
                        <li class="nav-item">
                            <a style="margin-left:100px; border: none;" class="btn btn-outline-light" href="controlador?menu=NuevaVenta&accion=default" target="myFrame">
                                <img src="folder/NuevaVEnta.png" alt="60" width="60"/>
                                <br>Nueva Venta</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown">
                    <button style="border:none;" class="btn btn-outline-light dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuario.getNom()}
                    </button>
                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                        <a class="dropdown-item" href="#">
                            <img src="img/user.png" alt="60" width="60"/>
                        </a>
                        <a class="dropdown-item" href="#">${usuario.getNom()}</a>
                        <a class="dropdown-item" href="#">Usuario@gmail.com</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <input class="dropdown-item" type="submit" value="Salir" name="accion"/>
                        </form>   
                    </div>
                </div>
            </div>
        </nav>

        <div class="m-4" style="height:550px;">
            <iframe name="myFrame" style="height:100%; width:100%;"></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    </body>

</html>
