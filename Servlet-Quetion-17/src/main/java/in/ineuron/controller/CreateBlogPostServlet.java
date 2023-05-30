package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.model.BlogPost;
import in.ineuron.util.DBUtil;

@WebServlet("/create")
public class CreateBlogPostServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");

		// Create a new BlogPost object
		BlogPost blogPost = new BlogPost();
		blogPost.setTitle(title);
		blogPost.setDescription(description);
		blogPost.setContent(content);

		// Save the BlogPost object to the database
		try {
			Connection connection = DBUtil.getConnection();
			String sql = "INSERT INTO blogposts (title, description, content) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, blogPost.getTitle());
			statement.setString(2, blogPost.getDescription());
			statement.setString(3, blogPost.getContent());
			statement.executeUpdate();

			response.sendRedirect("view");
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("An error occurred while creating the blog post.");
		}
	}
}
