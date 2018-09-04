package xiaoxiong.blog.controller;

import org.springframework.web.bind.annotation.*;
import xiaoxiong.blog.annotations.ControlLog;
import xiaoxiong.blog.request.AdminRequest;
import xiaoxiong.blog.result.ResultMsg;
import xiaoxiong.blog.utils.ResultUtil;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/8/24
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @PostMapping("/register")
    @ControlLog("注册")
    public ResultMsg register(AdminRequest adminRequest){

        return ResultUtil.success(null);
    }

}
