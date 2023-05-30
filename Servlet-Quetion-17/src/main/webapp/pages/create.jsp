<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="style.css">
<head>
    <title>Create Blog Post</title>
</head>
<body>
    <h1>Create a New Blog Post</h1>
    <form action="/create" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required><br>
        <label for="content">Content:</label><br>
        <textarea id="content" name="content" rows="5" cols="50" required></textarea><br>
        <input type="submit" value="Create Post">
    </form>
</body>
</html>
