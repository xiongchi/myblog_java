package xiaoxiong.blog.web.services.impl.reply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xiaoxiong.blog.MyblogApplication;
import xiaoxiong.blog.web.dto.reply.ReplyDto;

import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogApplication.class)
@WebAppConfiguration
public class ReplyServiceImplTest {

    @Autowired
    private ReplyServiceImpl replyService;

    @Test
    public void saveReply() {
        Date date = new Date();
        ReplyDto replyDto = new ReplyDto();
        replyDto.setReplyId(String.valueOf(date.getTime()));
        replyDto.setReplyContent("sssssss");
        replyDto.setReplyTime(date);
        replyDto.setReplyZan(1);
        replyDto.setUserId(1);
        replyService.saveReply(replyDto);
    }

    @Test
    public void getReplysTest() {
        PageRequest request = new PageRequest(0, 2);
        Page<ReplyDto> replys = replyService.getReplys(1, request);
        System.out.println(replys);
    }
}