/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author t
 */
public class CategoryServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        DAO d = new DAO();
        String cid = request.getParameter("cid");
        
        List<Product> list = d.getProductCid(cid);
        
        // in list các div sản phẩm
        PrintWriter out = response.getWriter();
        for (Product o : list) {
            out.println("<div class=\"col-xl-3 col-lg-4 col-md-4 col-12\">\n" +
"                                                    <div class=\"single-product\">\n" +
"                                                        <div class=\"product-img\">\n" +
"                                                            <a href=\"details?pid="+o.getCid()+"\">\n" +
"                                                                <img class=\"default-img\" src=\"images/"+o.getImage()+"\" alt=\"#\">\n" +
"                                                                <img class=\"hover-img\" src=\"images/"+o.getImage()+"\" alt=\"#\">\n" +
"                                                            </a>\n" +
"                                                            <div class=\"button-head\">\n" +
"                                                                <div class=\"product-action\">\n" +
"                                                                    <a data-toggle=\"modal\" data-target=\"#exampleModal\" title=\"Quick View\" href=\"#\"><i class=\" ti-eye\"></i><span>Quick Shop</span></a>\n" +
"                                                                    <a title=\"Wishlist\" href=\"#\"><i class=\" ti-heart \"></i><span>Add to Wishlist</span></a>\n" +
"                                                                    <a title=\"Compare\" href=\"#\"><i class=\"ti-bar-chart-alt\"></i><span>Add to Compare</span></a>\n" +
"                                                                </div>\n" +
"                                                                <div class=\"product-action-2\">\n" +
"                                                                    <a title=\"Add to cart\" href=\"#\">Add to cart</a>\n" +
"                                                                </div>\n" +
"                                                            </div>\n" +
"                                                        </div>\n" +
"                                                        <div class=\"product-content\">\n" +
"                                                            <h3><a href=\"details?pid="+o.getCid()+"\">"+o.getName()+"</a></h3>\n" +
"                                                            <div class=\"product-price\">\n" +
"                                                                <span>"+o.getPrice()+"</span>\n" +
"                                                            </div>\n" +
"                                                        </div>\n" +
"                                                    </div>\n" +
"                                                </div>");
        }
        
//        request.setAttribute("listP", list);
//        
//        List<Category> listC = d.getAllCategory();
//        request.setAttribute("listC", listC);
//        
//        //Kiểm tra và trả về active 
        request.setAttribute("tag", cid);
//        
//        request.getRequestDispatcher("index.jsp").forward(request, response);
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
