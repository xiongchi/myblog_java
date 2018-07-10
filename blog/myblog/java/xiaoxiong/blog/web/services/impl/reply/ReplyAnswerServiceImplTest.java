package xiaoxiong.blog.web.services.impl.reply;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import xiaoxiong.blog.MyblogApplication;
import xiaoxiong.blog.web.dto.reply.ReplyAnswerDto;
import xiaoxiong.blog.web.services.reply.IReplyAnswerService;

import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogApplication.class)
@WebAppConfiguration
public class ReplyAnswerServiceImplTest {

    @Autowired
    private IReplyAnswerService replyAnswerService;

    @Test
    public void saveAnswer() {
        ReplyAnswerDto rad = new ReplyAnswerDto();
        rad.setAnswerId(String.valueOf(new Date().getTime()));
        rad.setAnswerContent("sadasa");
        rad.setAnswerTime(new Date());
        rad.setReplyId("11111");
        rad.setUserId(1);
        replyAnswerService.saveAnswer(rad);
    }
}