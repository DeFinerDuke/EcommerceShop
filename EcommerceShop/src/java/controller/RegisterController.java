/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.RegistrationInsertError;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BenNguyen
 */
public class RegisterController extends HttpServlet {

    private static final String CREATEPASSWORD = "create.jsp";
    private static final String REGISTRATION = "signup.jsp";

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
            String Username = request.getParameter("txtUsername");
            String FullName = request.getParameter("txtFullname");
            String Email = request.getParameter("txtEmail");
            String PhoneNumber = request.getParameter("txtPhonenumber");
            String Gender = request.getParameter("txtGender");
            String DOB = request.getParameter("txtDOB");
            String url = REGISTRATION;
            HttpSession session = request.getSession();
            boolean bErrors = false;
            RegistrationInsertError errors = new RegistrationInsertError();
            try {
                if (Username.trim().length() < 6 || Username.trim().length() > 12) {
                    bErrors = true;
                    errors.setUsernameLengthErr("Username must be between 6 and 12 characters");
                }

                if (FullName.trim().length() < 2 || FullName.trim().length() > 50) {
                    bErrors = true;
                    errors.setFullNameLengthErr("Full name must be between 2 and 50 characters");
                }
                if (isValidPhoneNumber(PhoneNumber)==true && PhoneNumber != null) {
                    bErrors = true;
                    errors.setPhonenumberIsInvalid("Invalid phone number");
                }

                if (isValidEmailAddress(Email)==false && !Email.isEmpty()) {
                    bErrors = true;
                    errors.setEmailIsInvalid("Invalid email");
                }
                if (bErrors) {
                    request.setAttribute("INSERTERROR", errors);
                } else {
                    UserDAO dao = new UserDAO();
                    boolean status = dao.RegisterAccount(Username, FullName, PhoneNumber, Email, Gender, DOB);
                    if (status) {
                        url = CREATEPASSWORD;
                        session.setAttribute("USERNAME", Username);
                    } else {
                        errors.setUsernameIsExisted("Username is existed");
                        request.setAttribute("INSERTERROR", errors);
                    }
                }

            } catch (UnsupportedEncodingException ex) {
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

    public static boolean isValidEmailAddress(String email) throws UnsupportedEncodingException {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isValidPhoneNumber(String s) {
        Pattern p = Pattern.compile("^\\+?[0-9]{2,3}+-[0-9]{10}$");
        Matcher m = p.matcher(s);
        return (m.matches());
    }
}
