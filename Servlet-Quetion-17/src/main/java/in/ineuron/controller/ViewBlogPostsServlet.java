package in.ineuron.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.model.BlogPost;
import in.ineuron.util.DBUtil;

@WebServlet("/view")
public class ViewBlogPostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			String sql = "SELECT * FROM blog_posts";
			ResultSet resultSet = statement.executeQuery(sql);

			List<BlogPost> blogPosts = new ArrayList<>();
			while (resultSet.next()) {
				BlogPost blogPost = new BlogPost();
				blogPost.setId(resultSet.getInt("id"));
				blogPost.setTitle(resultSet.getString("title"));
				blogPost.setDescription(resultSet.getString("description"));
				blogPost.setContent(resultSet.getString("content"));
				blogPosts.add(blogPost);
			}

			request.setAttribute("blogPosts", blogPosts);
			request.getRequestDispatcher("view.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("An error occurred while retrieving blog posts.");
		}
	}
}
