package com.mnl_laterite;

import io.javalin.core.security.Role;

public enum Roles implements Role {
  AUTHENTICATED, ANYONE;
}
