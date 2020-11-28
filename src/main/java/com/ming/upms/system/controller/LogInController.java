package com.ming.upms.system.controller;

import com.ming.upms.common.controller.BaseController;
import com.ming.upms.common.domain.Tree;
import com.ming.upms.common.util.MD5Utils;
import com.ming.upms.common.util.R;
import com.ming.upms.common.util.RandomValidateCodeUtil;
import com.ming.upms.common.util.ShiroUtils;
import com.ming.upms.system.domain.UpmsPermissionDO;
import com.ming.upms.system.domain.UpmsUserDO;
import com.ming.upms.system.service.UpmsPermissionService;
import com.ming.upms.system.service.UpmsUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "用户登录接口")
@Controller
public class LogInController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LogInController.class);

    @Autowired
    private UpmsUserService upmsUserService;

    @Autowired
    private UpmsPermissionService upmsPermissionService;

    @ApiOperation(value="主页面", notes="ming后台管理主页面")
    @GetMapping(value = {"", "/index"})
    String index(Model model) {
        //获取用户资源
        List<Tree<UpmsPermissionDO>> permissionDOList = upmsPermissionService.getTreeByUserId(getUserId());
        UpmsUserDO user = getUser();
        model.addAttribute("menus", permissionDOList);
        model.addAttribute("user", getUser());
        return "index";
    }

    @ApiOperation(value="首页", notes="ming后台管理首页，介绍项目信息")
    @GetMapping("/main")
    String main() {
        return "main";
    }

    /**
     * 登录页面
     * @return
     */
    @ApiOperation(value="登录页面", notes="登录页面")
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param verify
     * @param request
     * @return
     */
    @ApiOperation(value="登录接口", notes="登录接口")
    @PostMapping("/login")
    @ResponseBody
    public R ajaxLogin(String username, String password, String verify, HttpServletRequest request) {
        //检验验证码
        try {
            String random = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
            if (StringUtils.isBlank(verify)) {
                return R.error("请输入验证码！");
            }
            if(!random.equalsIgnoreCase(verify)) {
                return R.error("验证码不正确！");
            }
        } catch (Exception e) {
            logger.error("get verify is error:", e);
            return R.error("验证码校验失败！");
        }
        UpmsUserDO user = upmsUserService.getUserByusername(username);
        if (user == null || user.getUserId() == null) {
            return R.error("用户不存在！");
        }
        //密码加盐
        password += user.getSalt();
        //验证用户信息
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (LockedAccountException e) {
            return R.error("用户被锁定，请找管理员处理！");
        } catch (AuthenticationException e) {
            return R.error("用户名密码错误！");
        }
    }

    @ApiOperation(value="注销接口", notes="注销退出接口")
    @GetMapping("/logout")
    public String logout() {
        ShiroUtils.logout();
        return "redirect:/login";
    }

    @ApiOperation(value="获取验证码", notes="登录时获取验证码图片")
    @GetMapping("/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        RandomValidateCodeUtil validateCodeUtil = new RandomValidateCodeUtil();
        validateCodeUtil.getRandcode(request, response);
    }

}
