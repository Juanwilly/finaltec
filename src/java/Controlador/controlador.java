/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import config.GenerarSerie;

public class controlador extends HttpServlet {
    Empleado em=new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();
    Producto p=new Producto();
    ProductoDAO pdao =new ProductoDAO();
    Cliente c= new Cliente();
    ClienteDAO cdao= new ClienteDAO();
    Venta v = new Venta();
    List<Venta>lista=new ArrayList<>();
    VentaDAO vdao = new VentaDAO();
    //Atributos venta
    int item=0;
    int cod;
    String descripcion;
    int precio;
    int cant;
    int subtotal;
    int totalPagar;
    String numeroserie;
    //Fin Atributos Venta
    Date fechaActual = new Date();
    String fechaformat=new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
    int ide;
    int idp;
    int idc;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu=request.getParameter("menu");
        String accion=request.getParameter("accion");
        if (menu.equals("Producto")) {
            lista.clear();
            switch (accion) {
                case "ListarProducto":
                       List lista=pdao.listar();
                       request.setAttribute("productos", lista);
                    break;
                case "Agregar":
                        String nom=request.getParameter("txtNombre");
                        int precio=Integer.parseInt(request.getParameter("txtPrecio"));
                        int stock=Integer.parseInt(request.getParameter("txtStock"));
                        String est=request.getParameter("txtEstado");
                        p.setNombres(nom);
                        p.setPrecio(precio);
                        p.setStock(stock);
                        p.setEstado(est);
                        pdao.agregar(p);
                        request.getRequestDispatcher("controlador?menu=Producto&accion=ListarProducto").forward(request, response);
                case "EditarProducto":
                        idp=Integer.parseInt(request.getParameter("id"));
                        Producto prod=pdao.listarId(idp);
                        request.setAttribute("producto",prod);
                        request.getRequestDispatcher("controlador?menu=Producto&accion=ListarProducto").forward(request, response);
                    break;
                case "Actualizar":
                        String nom1=request.getParameter("txtNombre");
                        int precio1=Integer.parseInt(request.getParameter("txtPrecio"));
                        int stock1=Integer.parseInt(request.getParameter("txtStock"));
                        String est1=request.getParameter("txtEstado");
                        p.setNombres(nom1);
                        p.setPrecio(precio1);
                        p.setStock(stock1);
                        p.setEstado(est1);
                        p.setIdProducto(idp);
                        pdao.actualizar(p);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=ListarProducto").forward(request, response);
                    break;
                case "DeleteProducto":
                    idp=Integer.parseInt(request.getParameter("id"));
                    pdao.delete(idp);
                    request.getRequestDispatcher("controlador?menu=Producto&accion=ListarProducto").forward(request, response);                    
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("Principal")) {
            request.getRequestDispatcher("Principal.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            lista.clear();
            switch (accion) {
                case "ListarCliente":
                       List lista=cdao.listar();
                       request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtDireccion");
                        String est=request.getParameter("txtEstado");
                        c.setDni(dni);
                        c.setNombres(nom);
                        c.setDireccion(tel);
                        c.setEstado(est);
                        cdao.agregar(c);
                        request.getRequestDispatcher("controlador?menu=Cliente&accion=ListarCliente").forward(request, response);
                case "EditarCliente":
                        idc=Integer.parseInt(request.getParameter("id"));
                        Cliente cl=cdao.listarId(idc);
                        request.setAttribute("cliente",cl);
                        request.getRequestDispatcher("controlador?menu=Cliente&accion=ListarCliente").forward(request, response);
                    break;
                case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtDireccion");
                        String est1=request.getParameter("txtEstado");
                        c.setDni(dni1);
                        c.setNombres(nom1);
                        c.setDireccion(tel1);
                        c.setEstado(est1);
                        c.setIdCliente(idc);
                        cdao.actualizar(c);
                    request.getRequestDispatcher("controlador?menu=Cliente&accion=ListarCliente").forward(request, response);
                    break;
                case "DeleteCliente":
                    idc=Integer.parseInt(request.getParameter("id"));
                    cdao.delete(idc);
                    request.getRequestDispatcher("controlador?menu=Cliente&accion=ListarCliente").forward(request, response);                    
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Clientes.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
            lista.clear();
            switch (accion) {
                case "Listar":
                       List lista=edao.listar();
                       request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                        String dni=request.getParameter("txtDni");
                        String nom=request.getParameter("txtNombres");
                        String tel=request.getParameter("txtTelefono");
                        String est=request.getParameter("txtEstado");
                        String user=request.getParameter("txtUsuario");
                        em.setDni(dni);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEstado(est);
                        em.setUser(user);
                        edao.agregar(em);
                        request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                case "Editar":
                        ide=Integer.parseInt(request.getParameter("id"));
                        Empleado e=edao.listarId(ide);
                        request.setAttribute("empleado",e);
                        request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                        String dni1=request.getParameter("txtDni");
                        String nom1=request.getParameter("txtNombres");
                        String tel1=request.getParameter("txtTelefono");
                        String est1=request.getParameter("txtEstado");
                        String user1=request.getParameter("txtUsuario");
                        em.setDni(dni1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEstado(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);
                    
                    break;
                case "Delete":
                    ide=Integer.parseInt(request.getParameter("id"));
                    edao.delete(ide);
                    request.getRequestDispatcher("controlador?menu=Empleado&accion=Listar").forward(request, response);                    
                    break;
                default:
                    
                    throw new AssertionError();
            }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("NuevaVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni=request.getParameter("codigocliente");
                    c.setDni(dni);
                    c=cdao.buscar(dni);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("lista", lista);
                    request.setAttribute("c", c);
                    break;
                case "BuscarProducto":
                    int id=Integer.parseInt(request.getParameter("codigoproducto"));
                    p=pdao.listarId(id);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("producto", p);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("c", c);
                    break;
                case "Agregar":
                    v=new Venta();
                    cod= p.getIdProducto();
                    descripcion=request.getParameter("nomproducto");
                    precio = Integer.parseInt(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subtotal = precio * cant;
                    totalPagar=0;
                    v.setItem(item);
                    v.setIdproducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar=totalPagar+(lista.get(i).getSubtotal());
                    }
                    item = item +1;
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("c", c);
                    break;
                case "GenerarVenta":
                    
                    //Actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();
                        int cantidad=lista.get(i).getCantidad();
                        int idproducto=lista.get(i).getIdproducto();
                        ProductoDAO dao = new ProductoDAO();
                        pr=dao.buscar(idproducto);
                        int sac=pr.getStock()-cantidad;
                        dao.actualizarstock(idproducto, sac);
                    }
                    //Guardar Venta
                    v.setIdcliente(c.getIdCliente());
                    v.setIdempleado(8);// DEBO HACER QUE LISTE BIEN AL EMPLEADO 
                    v.setNumserie(numeroserie);
                    v.setFecha(fechaformat);
                    v.setMonto(totalPagar);
                    v.setEstado("1"); //TAMNBIEN DEBO HACER QUE LOS ITEMS DE LA LISTA SE PUEDAN ELIMINAR
                    vdao.guardarVenta(v);
                    //guardar detalle venta
                    int idv=Integer.parseInt(vdao.IdVentas());
                    for (int i = 0; i < lista.size(); i++) {
                        v.setId(idv);
                        v.setIdproducto(lista.get(i).getIdproducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleventas(v);
                    }
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("c", c);
                    break;
                case "Eliminar":
                    id=Integer.parseInt(request.getParameter("id"));
                    lista.remove(id);
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "Cancelar":
                    lista.clear();
                    totalPagar=0;
                    item=0;
                    request.setAttribute("nserie", numeroserie);
                    request.setAttribute("totalpagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                default:
                    numeroserie = vdao.GenertarSerie();
                    if (numeroserie==null) {
                        numeroserie="000000001";
                        request.setAttribute("nserie", numeroserie);
                    }
                    else{
                        int incrementar=Integer.parseInt(numeroserie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroserie = gs.NumeroSerie(incrementar);
                        request.setAttribute("nserie", numeroserie);
                    }
                    request.setAttribute("nserie", numeroserie);    
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
