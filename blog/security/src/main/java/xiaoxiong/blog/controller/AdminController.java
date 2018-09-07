package xiaoxiong.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xiaoxiong.blog.annotations.ControlLog;
import xiaoxiong.blog.request.AdminRequest;
import xiaoxiong.blog.response.AdminResponse;
import xiaoxiong.blog.result.ResultMsg;
import xiaoxiong.blog.services.IAdminService;
import xiaoxiong.blog.utils.ResultUtil;

import javax.servlet.http.HttpSession;


/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/8/24
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @PostMapping("/register")
    @ControlLog("注册")
    public ResultMsg register(@Validated AdminRequest adminRequest, HttpSession session){
        AdminResponse adminResponse = adminService.registerService(adminRequest);
        return ResultUtil.success(adminResponse);
    }

}
