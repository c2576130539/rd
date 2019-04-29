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
import org.springframework.web.multipart.MultipartFile;

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
        return JSONResult.success(accountService.newUserCode(telphone));
    }

    @ApiOperation(value = "发送老用户手机注册验证码")
    @PostMapping("/accounts/oldsendsms/{telphone}")
    public JSONResult sendOldCode(@PathVariable String telphone) {
        return JSONResult.success(accountService.oldUserCode(telphone));
    }

    @ApiOperation(value = "验证手机验证码正确性")
    @PostMapping("/accounts/checksms")
    public JSONResult checkSms(@RequestBody TelphoneCodeRequest telphoneCodeRequest) {
        return JSONResult.success(accountService.isRightCode(telphoneCodeRequest));
    }

    @ApiOperation(value = "注册手机用户")
    @PostMapping("/accounts/registers")
    public JSONResult registerUser(@RequestBody UserAddRequest userAddRequest) {
        return JSONResult.success(accountService.registerUser(userAddRequest));
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
            return JSONResult.success(true);
        }
        // 在redis里面存登出的用户id, 让所有其他登陆的地方全部失效
        return JSONResult.success(logOutService.setLogoutStatus(userId));
    }

    @ApiOperation(value = "找回密码")
    @PatchMapping("/accounts/passwords/reset")
    public JSONResult resetPwd(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        return JSONResult.success(accountService.resetPassword(resetPasswordRequest));
    }

    @ApiOperation(value = "更换手机号码")
    @PatchMapping("/telphone/reset")
    public JSONResult resetTelphone(@RequestBody TelphoneCodeRequest telphoneCodeRequest) {
        return JSONResult.success(accountService.resetTelphone(telphoneCodeRequest, Long.valueOf(getUserId())));
    }

    @ApiOperation(value = "修改密码")
    @PatchMapping("/passwords/modifications")
    public JSONResult changePwd(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
        return JSONResult.success(accountService.updatePassword(updatePasswordRequest, Long.valueOf(getUserId())));
    }

    @ApiOperation(value = "更换头像")
    @PutMapping("/users")
    public JSONResult changeUserImage(@RequestBody UserDetailRequest request) {
        return JSONResult.success(accountService.updateUserDetail(request, Long.valueOf(getUserId())));
    }

    @ApiOperation(value = "解锁")
    @Delete("/unlock")
    public JSONResult unlockTel(@PathVariable String telphone) {
        return JSONResult.success(accountService.deleteByTel(telphone));
    }
}
    