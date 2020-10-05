package com.ssafy.work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ssafy.work.Book;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/regist")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // parameter 분석
        String isbn1 = request.getParameter("isbn1");
        String isbn2 = request.getParameter("isbn2");
        String isbn3 = request.getParameter("isbn3");
        String title = request.getParameter("title");
        String catalogue = request.getParameter("catalogue");
        String nation = request.getParameter("nation");
        String pubdateStr = request.getParameter("pubdate");
        String publisher = request.getParameter("publisher");
        String author = request.getParameter("author");
        String priceStr = request.getParameter("price");
        String currency = request.getParameter("currency");
        String desc = request.getParameter("description");

        // 적졀한 형 변환 필요
        String isbn = String.format("%s-%s-%s", isbn1, isbn2, isbn3);
        Date pubDate = todate(pubdateStr);
        int price = priceStr.equals("") ? 0 : Integer.parseInt(priceStr);



        Book book = new Book(isbn, title, catalogue, nation, pubDate, publisher, author, price,
                currency, desc);
        System.out.println(book);

        HttpSession session = request.getSession();
        session.setAttribute("book", book);
        response.sendRedirect(request.getContextPath() + "/0918/result.jsp");
    }

    private Date todate(String date) {
        try {
            // 문자열 <--> Date
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
