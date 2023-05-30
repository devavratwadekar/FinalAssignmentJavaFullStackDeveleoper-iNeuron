import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("DEVAVRAT");

		response.setContentType("text/html");
		response.getWriter().println("<html><body>");

		if (name == null) {
			response.getWriter().println("<h2>Welcome, Guest!</h2>");
		} else {
			response.getWriter().println("<h2>Welcome, " + name + "!</h2>");
		}

		response.getWriter().println("<a href=\"updateName\">Update Name</a>");
		response.getWriter().println("</body></html>");
	}
}

@SuppressWarnings("serial")
@WebServlet("/updateName")
class UpdateNameServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");

		HttpSession session = request.getSession();
		session.setAttribute("name", name);

		response.sendRedirect("welcome");
	}
}
