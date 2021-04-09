package com.example.backend.security;

public class SecurityConstants {

    public static final long EXPIRATION_DATE = (60 * 60 * 24 * 30);// Tiempo de expiración del jason token
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users";
    public static final String TOKEN_SECRET = "Z3gNRRW7WOAyBvZJ9rWlFSEZ474XqknP";
    
}
