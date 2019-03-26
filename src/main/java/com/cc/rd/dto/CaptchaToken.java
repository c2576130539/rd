package com.cc.rd.dto;

import com.cc.rd.enums.Constant;
import com.cc.rd.util.DateTimeUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @program: CaptchaToken
 * @description:
 * @author: cchen
 * @create: 2019-03-06 15:35
 */
@Data
public class CaptchaToken implements Serializable {

    private String code;

    private Long issuedAt = DateTimeUtils.utcNow();

    private Long expiredAt = this.issuedAt + Constant.DEFAULT_TTL;

    public boolean isInvalid() {

        long now = DateTimeUtils.utcNow();
        // 过期
        boolean isExpired = now >= expiredAt;
        // 输入时间太快
        boolean isTooFast = Math.abs(now - issuedAt) <= 1000;

        return StringUtils.isEmpty(code) || isExpired || isTooFast;
    }

}
    