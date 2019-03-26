package com.cc.rd.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cc.rd.enums.Constant;
import com.cc.rd.enums.ErrorCodeEnum;
import com.cc.rd.exception.ManagerException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: JwtUtils
 * @description:
 * @author: cchen
 * @create: 2019-03-07 15:40
 */
public class JwtUtils {

    private final static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    private static String key = "rdsecret";

    public static String getToken(Map<String, Object> map) throws Exception {
        String userId = (String) map.get("userId");
        String telphone=(String)map.get("telphone");
        Map<String, Object> mapHeader = new HashMap<>(2);
        mapHeader.put("alg", "HS256");
        mapHeader.put("typ", "JWT");
        long iat = DateTimeUtils.utcNow();
        long exp = iat + Constant.MONTHS;
        String token = JWT.create()
                .withHeader(map)
                .withIssuedAt(new Date(iat))
                .withExpiresAt(new Date(exp))
                .withClaim("userId", userId)
                .withClaim("telphone",telphone)
                .sign(Algorithm.HMAC256(key));
        return token;
    }

    public static Map<String, Claim> verify(String token) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
            jwt = verifier.verify(token);
            return jwt.getClaims();
        } catch (Exception ex) {
            logger.error("verify jwt token failed, token={}", token, ex);
            return null;
        }

    }

    //从token中解析userId
    public static Long getUserIdFromToken(String token) {
        String userId = JwtUtils.verify(token).get("userId").asString();
        if (StringUtils.isEmpty(userId)) {
            throw new ManagerException(ErrorCodeEnum.USER_NOT_EXIST);
        }
        return Long.valueOf(userId);
    }

}
    