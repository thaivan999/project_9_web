package project_9.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/test", "/homee", "/branches", "/branches_info", "/cart", "/order", "/payment",
		"/product_detail", "/products", "/user_infor" })
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();

		if (url.contains("/test")) {
			req.getRequestDispatcher("/views/user/test.jsp").forward(req, resp);
		} else if (url.contains("/homee")) {
			req.getRequestDispatcher("/views/user/home/home.jsp").forward(req, resp);
		} else if (url.contains("/branches_info")) {
			req.getRequestDispatcher("/views/user/branches_info/branches_info.jsp").forward(req, resp);
		} else if (url.contains("/branches")) {
			req.getRequestDispatcher("/views/user/branches/branches.jsp").forward(req, resp);
		} else if (url.contains("/cart")) {
			req.getRequestDispatcher("/views/user/cart/cart.jsp").forward(req, resp);
		} else if (url.contains("/order")) {
			req.getRequestDispatcher("/views/user/order/order.jsp").forward(req, resp);
		} else if (url.contains("/payment")) {
			req.getRequestDispatcher("/views/user/payment/payment.jsp").forward(req, resp);
		} else if (url.contains("/product_detail")) {
			req.getRequestDispatcher("/views/user/product_detail/product_detail.jsp").forward(req, resp);
		} else if (url.contains("/products")) {
			req.getRequestDispatcher("/views/user/products/products.jsp").forward(req, resp);
		} else if (url.contains("/user_infor")) {
			req.getRequestDispatcher("/views/user/user_infor/user_infor.jsp").forward(req, resp);
		}
	}
}
