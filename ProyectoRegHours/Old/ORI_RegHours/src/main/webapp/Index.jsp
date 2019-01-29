<%-- 
    Document   : Index.jsp
    Created on : 10-ene-2019, 20:21:07
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/minty/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="Style/style.css"/>
        <title>RegHours</title>
    </head>
    <body>
        <div class='container-fluid'>
        <header>
            <jsp:include page="/WEB-INF/pages/header.jsp"/>
        </header>
        <main id="central-panel">
            <div class='container'>
            <section id="content-section">
                <jsp:include page="<%= 
                    ((String) request.getAttribute("action")) == null?
                        "/WEB-INF/pages/pagina_inicial.jsp" :
                        "/WEB-INF/pages/" + ((String) request.getAttribute("action")) + ".jsp"
                %>"/>
            </section>
            <section id="error-section">
                <jsp:include page="/WEB-INF/pages/errors.jsp"/>
            </section>
            </div>
        </main>
        <footer>
            <!-- ACABAR EL FOOTER -->
            <p>This is the footer!</p>
        </footer>
    </body>
    </div>
</html>
