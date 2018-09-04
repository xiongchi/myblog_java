package xiaoxiong.blog.web.services.inf.reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xiaoxiong.blog.web.dto.reply.ReplyDto;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
public interface IReplyService {

    ReplyDto saveReply(ReplyDto dto);

    Page<ReplyDto> getReplys(Integer userId, Pageable pageable);

}
