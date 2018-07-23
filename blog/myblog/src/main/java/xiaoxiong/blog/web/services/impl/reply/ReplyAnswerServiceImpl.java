package xiaoxiong.blog.web.services.impl.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.annotations.MethodLogAnno;
import xiaoxiong.blog.web.convert.ReplyAnswerConvert;
import xiaoxiong.blog.web.dto.reply.ReplyAnswerDto;
import xiaoxiong.blog.web.entity.reply.ReplyAnswer;
import xiaoxiong.blog.web.repository.reply.ReplyAnswerRepository;
import xiaoxiong.blog.web.services.reply.IReplyAnswerService;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/4
 */
@Component("replyAnswerService")
public class ReplyAnswerServiceImpl implements IReplyAnswerService {

    @Autowired
    private ReplyAnswerConvert replyAnswerConvert;

    @Autowired
    private ReplyAnswerRepository replyAnswerRepository;

    @Override
    @MethodLogAnno("service---保存回复")
    public ReplyAnswerDto saveAnswer(ReplyAnswerDto rad) {
        ReplyAnswer ra = replyAnswerConvert.toEntity(rad);
        ReplyAnswer saveRa = replyAnswerRepository.save(ra);
        return replyAnswerConvert.toDto(saveRa);
    }
}
