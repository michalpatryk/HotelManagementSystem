package pl.polsl.hotelmanagementsystem.domain.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, CLIENT, MANAGER, GUEST, KITCHEN, ROOM_SERVICE, RECEPTION;
    public String getAuthority(){
        return name();
    }
}
