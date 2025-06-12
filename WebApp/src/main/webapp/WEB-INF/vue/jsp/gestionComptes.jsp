<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestion des Comptes</title>
    <link rel="stylesheet" href="../../html/style.css">
</head>
<body>
    <div class="container">
        <h1>Gestion des Comptes</h1>
        
        <% if (request.getAttribute("message") != null) { %>
            <div class="message"><%= request.getAttribute("message") %></div>
        <% } %>
        
        <% if (request.getAttribute("erreur") != null) { %>
            <div class="erreur"><%= request.getAttribute("erreur") %></div>
        <% } %>
        
        <h2>Créer un compte</h2>
        <form action="ConnexionCTRL" method="POST">
            <input type="hidden" name="action" value="creerCompte">
            
            <div class="form-group">
                <label for="login">Login:</label>
                <input type="text" id="login" name="login" required>
            </div>
            
            <div class="form-group">
                <label for="password">Mot de passe:</label>
                <input type="password" id="password" name="password" required>
            </div>
            
            <button type="submit">Créer</button>
        </form>
        
        <h2>Supprimer un compte</h2>
        <form action="ConnexionCTRL" method="POST">
            <input type="hidden" name="action" value="supprimerCompte">
            
            <div class="form-group">
                <label for="loginSuppr">Login:</label>
                <input type="text" id="loginSuppr" name="loginSuppr" required>
            </div>
            
            <button type="submit">Supprimer</button>
        </form>
        
        <a href="espaceAdmin.jsp">Retour</a>
    </div>
</body>
</html>