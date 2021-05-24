package pl.polsl.hotelmanagementsystem.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_CLIENT, ROLE_MANAGER, ROLE_GUEST, ROLE_KITCHEN, ROLE_ROOM_SERVICE, ROLE_RECEPTION;
    public String getAuthority(){
        return name();
    }
}
