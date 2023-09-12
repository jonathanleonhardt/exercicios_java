package br.com.syonet.domain;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table( name = "usuario" )
@UserDefinition
public class Usuario extends PanacheEntity {

    @Username
    public String username;

    @Password
    public String password;

    @Roles
    public String role;

    public static void addUser( String username, String password, String role ) {
        Usuario user = new Usuario();
        user.username = username;
        user.password = BcryptUtil.bcryptHash( password );
        user.role = role;
        user.persist();
    }

}
