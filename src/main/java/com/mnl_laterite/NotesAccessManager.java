package com.mnl_laterite;

import io.javalin.core.security.AccessManager;
import io.javalin.core.security.Role;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class NotesAccessManager implements AccessManager {

  @Override
  public void manage (@NotNull Handler handler, @NotNull Context ctx, @NotNull Set<Role> permittedRoles) throws Exception {
    final User user = (User) ctx.sessionAttribute("user");

    if (permittedRoles.contains(Roles.AUTHENTICATED) && user == null) {
      ctx.result("Unauthenticated");
      ctx.status(401);
    } else {
      handler.handle(ctx);
    }
  }
}
