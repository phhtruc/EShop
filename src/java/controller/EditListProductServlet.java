/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author t
 */
public class EditListProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws org.apache.commons.fileupload.FileUploadException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // Kiểm tra xem request có phải là một multipart request hay không
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(request);

                String nameProduct = null;
                int id = 0;
                float priceFloat = 0;
                int quantityInt = 0;
                int idCategory = 0;
                String desc = null;
                String fileName = null;

                // Duyệt qua các trường trong request
                for (FileItem item : items) {
                    // Kiểm tra xem trường hiện tại có phải là trường tải lên tệp hình ảnh hay không
                    if (!item.isFormField()) {
                        String fieldName = item.getFieldName();
                        fileName = item.getName();

                        // Lưu tệp hình ảnh vào máy
                        String savePath = "C:\\Code\\netbean\\EShop\\web\\images";
                        File file = new File(savePath, fileName);
                        item.write(file);
                    } else {
                        // Xử lý các trường thông thườngs
                        String fieldName = item.getFieldName();
                        String fieldValue = item.getString();
                                
                        if (fieldName.equals("txtNameProduct")) {
                            nameProduct = fieldValue;
                        } else if (fieldName.equals("txtPriceProduct")) {
                            priceFloat = Float.parseFloat(fieldValue);
                        } else if (fieldName.equals("txtQuantityProduct")) {
                            quantityInt = Integer.parseInt(fieldValue);
                        } else if (fieldName.equals("selectCategory")) {
                            idCategory = Integer.parseInt(fieldValue);
                        } else if (fieldName.equals("txtDesc")) {
                            desc = fieldValue;
                        } else if (fieldName.equals("id")) {
                            id = Integer.parseInt(fieldValue);
                        }
                    }
                }
                DAO d = new DAO();
                Product product = new Product(id, nameProduct, priceFloat, quantityInt, desc, fileName, idCategory);
                d.EditProMana(product);

                response.sendRedirect("listmanager"); // Thay thế bằng trang cần hiển thị sau khi tải lên thành công
            } catch (Exception e) {
                response.sendRedirect("upload_error.jsp"); // Thay thế bằng trang thông báo lỗi khi xảy ra vấn đề trong việc tải lên
            }
        } else {
            response.sendRedirect("upload_error.jsp"); // Thay thế bằng trang thông báo lỗi khi không nhận diện được tệp tải lên
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditListProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EditListProductServlet.class.getName()).log(Level.SEVERE, null, ex);
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
