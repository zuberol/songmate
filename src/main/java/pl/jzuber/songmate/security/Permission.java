package pl.jzuber.songmate.security;

import org.springframework.security.core.GrantedAuthority;

public enum Permission implements GrantedAuthority {

    STUDENT_READ("student:read"),
    STUDENT_WRITE("student:write"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    @Override
    public String getAuthority() {
        return getPermission();
    }

    public String getPermission() {
        return permission;
    }

}
