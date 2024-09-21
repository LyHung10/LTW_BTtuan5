package vn.iotstar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.service.IUserService;
import vn.iotstar.service.impl.UserServiceImpl;
import vn.iotstar.service.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/register" })

public class RegisterController extends HttpServlet {
	UserServiceImpl service = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname"  );
		String phone = req.getParameter("phone");
		IUserService service = new UserServiceImpl();
		String alertMsg = "";
		
		if (service.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			return;
		}else {
			if (service.checkExistEmail(email)) {
				alertMsg = "Email đã tồn tại!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
				return;
			}
		}
		boolean isSuccess = service.register(username, password, email, fullname, phone);
		if (isSuccess) {
			alertMsg = "Đăng kí tài khoản thành công";
		//SendMail sm = new SendMail();
		//sm.sendMail(email, "Shopping.iotstar.vn", "Welcome to Shopping. Please Login to use service. Thanks !");
			req.setAttribute("alert", alertMsg);
			resp.sendRedirect(req.getContextPath() + "/login");
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
			}
		}
}
