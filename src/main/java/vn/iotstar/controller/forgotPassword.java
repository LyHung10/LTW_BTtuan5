//package vn.iotstar.controller;
//
//import java.io.IOException;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import vn.iotstar.models.UserModel;
//import vn.iotstar.service.IUserService;
//import vn.iotstar.service.impl.UserServiceImpl;
//
//@WebServlet(urlPatterns = { "/forgotPassword" })
//public class forgotPassword extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//    IUserService userService = new UserServiceImpl();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
//
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		 // Thiết lập encoding cho request và response
//        resp.setContentType("text/html");
//        resp.setCharacterEncoding("UTF-8");
//        req.setCharacterEncoding("UTF-8");
//
//        // Lấy tham số từ form nhập vào
//        String username = req.getParameter("username");
//        String email = req.getParameter("email");
//
//        // Gọi phương thức findByUserName() để tìm thông tin người dùng
//        UserModel user = userService.findByUserName(username);
//
//        // Kiểm tra nếu user không tồn tại
//        if (user == null) {
//            req.setAttribute("message", "Tài khoản không tồn tại.");
//            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
//            return;
//        }
//
//        // So sánh email và username nhập vào với dữ liệu từ cơ sở dữ liệu
//        if (user.getEmail().equals(email) && user.getUsername().equals(username)) {
//            // Nếu khớp, gửi email để reset mật khẩu
//           Email sm = new Email();
//           boolean test = sm.EmailSend(user);
//            
//            // Kiểm tra kết quả gửi email
//            if (test) {
//                req.setAttribute("message", "Vui lòng kiểm tra email để nhận mật khẩu mới.");
//            } else {
//                req.setAttribute("message", "Gửi email không thành công. Vui lòng thử lại.");
//            }
//        } else {
//            req.setAttribute("message", "Email hoặc tên người dùng không khớp.");
//            req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
//            return;
//        }
//        req.getRequestDispatcher("/views/forgotPassword.jsp").forward(req, resp);
//
//	}
//}
