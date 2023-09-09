/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
/**
 *
 * @author t
 */
public class LoginServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // Luu tai khoan mat khau
        Cookie arr[] = request.getCookies();
        if(arr != null){
            for (Cookie co : arr) {
                if(co.getName().equals("user")){
                    request.setAttribute("username", co.getValue());
                }
                if(co.getName().equals("pass")){
                    request.setAttribute("password", co.getValue());
                }
            }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
        DAO d = new DAO();
        
        String name = request.getParameter("user");
        String pass = request.getParameter("pass");
        String rem = request.getParameter("rem");
        
        Customer cus = d.loGinCus(name, pass);
        
        if(cus == null){
            request.setAttribute("erorr", "Tài khoản hoặc mật khẩu sai. Vui lòng nhập lại!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("acc", cus);
            //Customer c = (Customer) session.getAttribute("acc"); 
            //Đoạn session.getAttribute("acc"); sẽ trả về String, nên cần ép kiểu về Acc hoặc Customer
            
            Cookie cu = new Cookie("user", name);
            Cookie cp = new Cookie("pass", pass);
            
            cu.setMaxAge(24 * 60 * 60);
            if (rem == null) {
                cp.setMaxAge(0);
            } else {
                cp.setMaxAge(24 * 60 * 60);
            }
            response.addCookie(cu);
            response.addCookie(cp);
            response.sendRedirect("home");
        }
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
