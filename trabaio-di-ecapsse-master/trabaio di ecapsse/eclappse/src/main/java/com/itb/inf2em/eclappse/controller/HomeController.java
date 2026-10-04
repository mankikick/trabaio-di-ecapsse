package com.itb.inf2em.eclappse.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return """
                <!DOCTYPE html>
                <html lang="pt-BR">
                <head>
                  <meta charset="UTF-8">
                  <title>Eclappse API</title>
                </head>
                <body>
                  <h1>Eclappse API</h1>
                  <p>O backend está no ar. As rotas ficam em <code>/api/v1</code>.</p>
                  <ul>
                    <li><a href="/api/v1/usuarios">/api/v1/usuarios</a></li>
                    <li><a href="/api/v1/casos">/api/v1/casos</a></li>
                  </ul>
                </body>
                </html>
                """;
    }
}
