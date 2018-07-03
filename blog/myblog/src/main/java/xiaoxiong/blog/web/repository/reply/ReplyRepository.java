package xiaoxiong.blog.web.repository.reply;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xiaoxiong.blog.web.entity.reply.Reply;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
public interface ReplyRepository extends JpaRepository<Reply, String> {

    Page<Reply> findAllByUserId(Integer userId, Pageable pageable);
}
