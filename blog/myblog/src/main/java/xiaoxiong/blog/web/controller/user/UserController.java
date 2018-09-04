package xiaoxiong.blog.web.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiaoxiong.blog.annotations.ControlLog;
import xiaoxiong.blog.web.dto.user.UserDto;
import xiaoxiong.blog.web.services.inf.user.IUserService;
import xiaoxiong.blog.utils.ResultUtil;
import xiaoxiong.blog.result.ResultMsg;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("find/{id}")
    @ControlLog("查询用户ById")
    public ResultMsg findUserById(@PathVariable(name = "id") int id){
        UserDto dto = userService.getUserById(id);
        return ResultUtil.success(dto);
    }

}
