package servlet;

import controlador.ConsultarGastos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jhon
 */
/**Esta clase recoge los campos del formulario y crea un objeto de tipo ConsultarGastos, luego llama al metodo insertarGasto() 
 pasandole el idgasto, usuario, cantidad*/
public class ModificarGasto extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String tipo, idUsuario;
        float cantidad;
        int idGasto;
        
        idGasto =Integer.parseInt(request.getParameter("idgasto"));
        tipo = request.getParameter("tipo");
        cantidad = Float.parseFloat(request.getParameter("cantidad"));
        idUsuario = request.getParameter("idusuario");
        // Declaro el nuevo objeto de tipo gasto.
        ConsultarGastos con = new ConsultarGastos();
        //añado una variable buleana para guardar el resultado del metodo.
        boolean confir = con.modificarGasto(idGasto,cantidad, tipo, idUsuario);
       
        if(confir==true){
            response.sendRedirect("gastos.jsp");
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
