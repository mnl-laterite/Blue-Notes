package com.mnl_laterite;

import io.javalin.Javalin;
import io.javalin.core.security.BasicAuthCredentials;

import static io.javalin.apibuilder.ApiBuilder.crud;


public class App {

  public static UserService userService;
  public static NoteService noteService;

  public static void main (String[] args) {

    userService = new UserService();
    noteService = new NoteService();


    Javalin app = Javalin.create(config -> {
      config.addStaticFiles("/static");
      config.addSinglePageRoot("/", "/static/index.html");
      config.accessManager(new NotesAccessManager());
    }).start(80);

    app.routes(() -> {

      crud("notes/:id", new NoteController());

      app.get("/", ctx -> {

        ctx.contentType("text/html");
        if (ctx.sessionAttribute("user") == null) {
          ctx.result(App.class.getResourceAsStream("/static/login/login.html"));
        } else {
          ctx.result(App.class.getResourceAsStream("/static/index.html"));
        }
      });

      app.post("logout", ctx -> {
        ctx.req.getSession().invalidate();
      });

      app.post("login", ctx -> {
        final String authorization = ctx.req.getHeader("Authorization");
        final BasicAuthCredentials basicAuthCredentials = ctx.basicAuthCredentials();

        if (basicAuthCredentials != null) {
          final String username = basicAuthCredentials.getUsername();
          final String password = basicAuthCredentials.getPassword();


          if (UserController.authenticate(username, password)) {
            ctx.sessionAttribute("user", userService.getUserByUsername(username));
            ctx.status(200);
            return;
          }
        }

        ctx.result("Unauthenticated");
        ctx.status(401);
      });
    });
  }
}
