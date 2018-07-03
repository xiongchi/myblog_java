package xiaoxiong.blog.web.services.impl.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import xiaoxiong.blog.web.annotations.MethodLogAnno;
import xiaoxiong.blog.web.convert.ReplyConvert;
import xiaoxiong.blog.web.dto.reply.ReplyDto;
import xiaoxiong.blog.web.entity.reply.Reply;
import xiaoxiong.blog.web.repository.reply.ReplyRepository;
import xiaoxiong.blog.web.services.reply.IReplyService;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
@Component("replyService")
public class ReplyServiceImpl implements IReplyService {

    @Autowired
    private ReplyConvert replyConvert;

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    @MethodLogAnno("service---存储评论")
    public ReplyDto saveReply(ReplyDto dto) {
        Reply reply = replyConvert.toEntity(dto);
        Reply save = replyRepository.save(reply);
        return replyConvert.toDto(save);
    }

    @Override
    @MethodLogAnno("service---获取评论")
    public Page<ReplyDto> getReplys(Integer userId, Pageable pageable) {
        Page<Reply> replyPage = replyRepository.findAllByUserId(userId, pageable);
        Page<ReplyDto> replyDtos = replyConvert.toDtoPage(replyPage, pageable);
        return replyDtos;
    }

}
