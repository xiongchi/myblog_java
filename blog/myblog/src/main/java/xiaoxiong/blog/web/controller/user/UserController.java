package xiaoxiong.blog.web.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiaoxiong.blog.web.annotations.ControlAnno;
import xiaoxiong.blog.web.dto.user.UserDto;
import xiaoxiong.blog.web.services.user.IUserService;
import xiaoxiong.blog.web.utils.ResultUtil;
import xiaoxiong.blog.web.dto.user.UserDto;
import xiaoxiong.blog.web.annotations.ControlAnno;
import xiaoxiong.blog.web.result.ResultMsg;
import xiaoxiong.blog.web.services.user.IUserService;
import xiaoxiong.blog.web.utils.ResultUtil;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("find/{id}")
    @ControlAnno("查询用户ById")
    public ResultMsg findUserById(@PathVariable(name = "id") int id){
        UserDto dto = userService.getUserById(id);
        return ResultUtil.success(dto);
    }

}
