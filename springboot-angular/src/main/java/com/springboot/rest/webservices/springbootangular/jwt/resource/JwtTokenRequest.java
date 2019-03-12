package com.springboot.rest.webservices.springbootangular.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
  private String password;
    
    /*{
        "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ5dXZhbiIsImV4cCI6MTU0NzkyMTc1NywiaWF0IjoxNTQ3MzE2OTU3fQ.-DfUzfrq92Vtub0t4yxbrfhcGXZlwBD6iiKpyNnmx9NX6HGLNq6RTtfWu4VyNm3Je44Hiw8obUAO6YNkdWxF-Q"
    }*/


    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

