<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Blog Posts</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>All Blog Posts</h1>
    <table>
        <tr>
            <th>Title</th>
            <th>Description</th>
            <th>Content</th>
        </tr>
        <c:forEach var="blogPost" items="${blogPosts}">
            <tr>
                <td>${blogPost.title}</td>
                <td>${blogPost.description}</td>
                <td>${blogPost.content}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
