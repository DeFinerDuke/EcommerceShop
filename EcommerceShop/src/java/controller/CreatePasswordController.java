/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import entity.RegistrationInsertError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BenNguyen
 */
public class CreatePasswordController extends HttpServlet {

    private static final String CREATEPASSWORD = "create.jsp";
    private static final String LOGINPAGE = "login.jsp";
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
            String Username = request.getParameter("Username");
            String Password = request.getParameter("txtPassword");
            String ConfirmPassword = request.getParameter("txtConfirmPassword");
            String url = CREATEPASSWORD;
            RegistrationInsertError errors = new RegistrationInsertError();
            boolean berrors = false;
            try {
                if (isStrongPassword(Password) == false) {
                    berrors = true;
                    errors.setPasswordLengthErr("Password not strong enough");
                }

                if (!Password.equals(ConfirmPassword)) {
                    berrors = true;
                    errors.setConfirmNotMatch("Confirm password not match");
                }

                if (berrors) {
                    request.setAttribute("INSERTERROR", errors);
                } else {
                    UserDAO dao = new UserDAO();
                    boolean status = dao.CreatePassword(Username, Password);
                    if (status) {
                        request.setAttribute("USERNAME", Username);
                        request.setAttribute("PASSWORD", Password);
                        url = LOGINPAGE;
                    }
                }

            } catch (Exception ex) {
                ex.getMessage();
            } finally {
                RequestDispatcher dist = request.getRequestDispatcher(url);
                dist.forward(request, response);
            }
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

    static boolean isStrongPassword(String password) {
        // Regular expressions for password validation
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[!@#$%^&*()\\-+].*)";

        // Combine the regular expressions
        String passwordRegex = upperCaseChars + lowerCaseChars + numbers + specialChars;
        if (passwordRegex.length() < 8){
            return false;
        }

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(passwordRegex);

        // Create a matcher
        Matcher matcher = pattern.matcher(password);

        // Return true if the password matches the pattern
        return matcher.matches();
    }
}
