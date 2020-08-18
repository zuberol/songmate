package pl.jzuber.songmate.security;


import com.google.common.collect.Sets;

import java.util.Set;

import static pl.jzuber.songmate.security.Permission.*;


public enum Role {

    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

}
