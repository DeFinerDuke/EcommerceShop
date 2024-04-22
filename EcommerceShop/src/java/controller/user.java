/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BenNguyen
 */
public class user extends HttpServlet {

    private static final String PROFILE = "ProfileController";
    private static final String ADDRESS = "AddressController";
    private static final String CHANGEPASSWORD = "ChangePasswordController";
    private static final String UPDATEACCOUNT = "UpdateAccountController";
    private static final String CHECKEXISTEDSTORE = "CheckExistedStoreController";
    private static final String ADDADDRESSCONTROLLER = "AddAddressController";
    private static final String DELETEADDRESSCONTROLLER = "DeleteAddressController";
    private static final String UPDATEADDRESSCONTROLLER = "UpdateAddressController";

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
            String action = request.getParameter("action");
            String url = null;
            switch (action) {
                case "Profile":
                    url = PROFILE;
                    break;
                case "Addresses":
                    url = ADDRESS;
                    break;
                case "Add address":
                    url = ADDADDRESSCONTROLLER;
                    break;
                case "Update":
                    url = UPDATEADDRESSCONTROLLER;
                    break;
                case "Delete":
                    url = DELETEADDRESSCONTROLLER;
                    break;
                case "Change Password":
                    url = CHANGEPASSWORD;
                    break;
                case "Save":
                    url = UPDATEACCOUNT;
                    break;
                case "Seller Centre":
                    url = CHECKEXISTEDSTORE;
                    break;
                default:
                    break;
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
