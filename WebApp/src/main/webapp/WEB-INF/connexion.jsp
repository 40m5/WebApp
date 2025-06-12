<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Connexion</title>
    <link rel="stylesheet" href="../../html/style.css">
</head>
<body>
    <div class="container">
        <h1>Connexion</h1>
        
        <% if (request.getAttribute("erreur") != null) { %>
            <div class="erreur"><%= request.getAttribute("erreur") %></div>
        <% } %>
        
        <form action="ConnexionCTRL2" method="POST">
            <input type="hidden" name="action" value="connecter">
            
            <div class="form-group">
                <label for="login">Login:</label>
                <input type="text" id="login" name="login" required>
            </div>
            
            <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit">Se connecter</button>
        </form>
    </div>
</body>
</html>