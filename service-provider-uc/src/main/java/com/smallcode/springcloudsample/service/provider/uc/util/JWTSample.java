package com.smallcode.springcloudsample.service.provider.uc.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTSample {

    public static String SECRET = "LENNY-asdd";

    public static void main(String[] args) {
        try {
            //System.out.println(createToken());
            Map<String, Claim> claimMap = verifyToken("eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJuYW1lIjoi5byg5LiJIiwiZXhwIjoxNTIzNDI4ODU5LCJpYXQiOjE1MjM0Mjg3MzksImFnZSI6IjI4In0.7rmT64YLxpJsh0G2KXfSqxg5Sxh1tFJawA56TuH0HG4");
            System.out.println(claimMap.get("name").asString());
            System.out.println(claimMap.get("age").asString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static String createToken() throws UnsupportedEncodingException {
        Date iaDate = new Date();

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 2);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> header = new HashMap<String, Object>();
        header.put("alg", "HS256");
        header.put("type", "JWT");

        String token = JWT.create()
                .withHeader(header)
                .withClaim("name", "张三")
                .withClaim("age", "28")
                .withExpiresAt(expiresDate)
                .withIssuedAt(iaDate)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    public static Map<String, Claim> verifyToken(String token) throws UnsupportedEncodingException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();

        DecodedJWT jwt = null;

        try {
            jwt = verifier.verify(token);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jwt.getClaims();
    }
}
