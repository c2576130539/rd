package com.cc.rd.controller.user;

import com.cc.rd.controller.BaseController;
import com.cc.rd.request.user.*;
import com.cc.rd.service.user.AccountService;
import com.cc.rd.service.user.LogOutService;
import com.cc.rd.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

/**
 * @program: AccountController
 * @description: 账号相关操作
 * @author: cchen
 * @create: 2019-03-07 10:30
 */
@Api(description = "账号相关操作")
@RestController
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private LogOutService logOutService;

    @ApiOperation(value = "发送新用户手机注册验证码")
    @PostMapping("/accounts/newsendsms/{telphone}")
    public JSONResult sendNewCode(@PathVariable String telphone) {
        accountService.newUserCode(telphone);
        return JSONResult.success();
    }

    @ApiOperation(value = "发送老用户手机注册验证码")
    @PostMapping("/accounts/oldsendsms/{telphone}")
    public JSONResult sendOldCode(@PathVariable String telphone) {
        accountService.oldUserCode(telphone);
        return JSONResult.success();
    }

    @ApiOperation(value = "验证手机验证码正确性")
    @PostMapping("/accounts/checksms")
    public JSONResult checkSms(@RequestBody TelphoneCodeRequest telphoneCodeRequest) {
        accountService.isRightCode(telphoneCodeRequest);
        return JSONResult.success();
    }

    @ApiOperation(value = "注册手机用户")
    @PostMapping("/accounts/registers")
    public JSONResult registerUser(@RequestBody UserAddRequest userAddRequest) {
        accountService.registerUser(userAddRequest);
        return JSONResult.success();
    }

    @ApiOperation(value = "登陆")
    @PostMapping("/accounts/login")
    public JSONResult login(@RequestBody UserLoginRequest userLoginRequest) {
        return JSONResult.success(accountService.login(userLoginRequest));
    }

    @ApiOperation(value = "退出登陆")
    @DeleteMapping("/accounts/logout")
    public JSONResult logout() {
        String userId = getUserId();
        if (StringUtils.isEmpty(userId)) {
            return JSONResult.success();
        }
        // 在redis里面存登出的用户id, 让所有其他登陆的地方全部失效
        logOutService.setLogoutStatus(userId);
        return JSONResult.success();
    }

    @ApiOperation(value = "找回密码")
    @PatchMapping("/accounts/passwords/reset")
    public JSONResult resetPwd(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        accountService.resetPassword(resetPasswordRequest);
        return JSONResult.success();
    }

    @ApiOperation(value = "更换手机号码")
    @PatchMapping("/telphone/reset")
    public JSONResult resetTelphone(@RequestBody TelphoneCodeRequest telphoneCodeRequest) {
        accountService.resetTelphone(telphoneCodeRequest, Long.valueOf(getUserId()));
        return JSONResult.success();
    }

    @ApiOperation(value = "修改密码")
    @PatchMapping("/passwords/modifications")
    public JSONResult changePwd(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        accountService.updatePassword(updatePasswordRequest, Long.valueOf(getUserId()));
        return JSONResult.success();
    }

    @ApiOperation(value = "解锁")
    @Delete("/unlock")
    public JSONResult unlockTel(@PathVariable String telphone) {
        accountService.deleteByTel(telphone);
        return JSONResult.success();
    }
}
    