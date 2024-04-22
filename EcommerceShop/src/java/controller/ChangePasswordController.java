/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import entity.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BenNguyen
 */
public class ChangePasswordController extends HttpServlet {

    private static final String PRIVACY_PAGE = "privacy.jsp";

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("USERNAME");
            String newPassword = request.getParameter("NewPassword");
            String oldPassword = request.getParameter("OldPassword");
            String confirmPassword = request.getParameter("ConfirmPassword");
            UserDAO dao = new UserDAO();
            String url = PRIVACY_PAGE;

            if (oldPassword == null || newPassword == null || confirmPassword == null
                    || oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                request.setAttribute("NULL_ERROR", "Please fill in all fields.");
            } else {
                UserDTO user = dao.CheckLogin(username, oldPassword);
                if (user == null) {
                    request.setAttribute("CHECKED_PASSWORD", "Incorrect old password.");
                } else if (!newPassword.equals(confirmPassword)) {
                    request.setAttribute("ERROR_CHANGE", "New passwords do not match.");
                } else {
                    boolean changedSuccess = dao.ChangePassword(username, newPassword);
                    if (changedSuccess) {
                        request.setAttribute("PASSWORD_STATUS", "Password changed successfully.");
                    } else {
                        request.setAttribute("PASSWORD_STATUS", "Failed to change password.");
                    }
                }
            }
            RequestDispatcher dist = request.getRequestDispatcher(url);
            dist.forward(request, response);
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
