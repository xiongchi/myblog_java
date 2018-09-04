package xiaoxiong.blog.web.controller.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import xiaoxiong.blog.web.dto.reply.ReplyDto;
import xiaoxiong.blog.result.ResultMsg;
import xiaoxiong.blog.web.services.inf.reply.IReplyService;
import xiaoxiong.blog.utils.ResultUtil;

import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
@RestController
@RequestMapping("reply")
public class ReplyController {

    @Autowired
    private IReplyService replyService;

    @PostMapping("save")
    @CrossOrigin
    public ResultMsg saveReply(ReplyDto replyDto){
        replyDto.setUserId(1);
        replyDto.setReplyZan(1);
        replyDto.setReplyTime(new Date());
        replyDto.setReplyId(String.valueOf(new Date().getTime()) + String.valueOf(replyDto.getUserId()));
        ReplyDto rd = replyService.saveReply(replyDto);
        return ResultUtil.success(rd);
    }


    @GetMapping("all/{userId}")
    public ResultMsg findReply(@PathVariable(name = "userId") Integer userId, @PageableDefault(value = 6,
            sort = {"replyTime"}, direction = Sort.Direction.DESC) Pageable pageable){
        Page<ReplyDto> replys = replyService.getReplys(userId, pageable);
        return ResultUtil.success(replys);
    }

}
