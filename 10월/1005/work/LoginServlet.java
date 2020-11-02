package com.ssafy.work;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 1. 파라미터 처리
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        // 2. 비지니스 로직 처리
        boolean result = "ssafy".equals(id) && "1111".equals(pass);

        // 3. 화면 처리
        if (result) {
            // 로그인 성공 - 정보를 세션에 담아주자.
            HttpSession session = request.getSession();
            // 아이디에 대한 부분은 세션을 통해서 전달해야 한다.
            session.setAttribute("loginId", id);

            response.sendRedirect(request.getContextPath() + "/0918/loginsuccess.jsp");

        } else {
            response.sendRedirect(request.getContextPath() + "/0918/login.jsp");
        }
    }

}
