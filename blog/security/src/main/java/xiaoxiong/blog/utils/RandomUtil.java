package xiaoxiong.blog.utils;

import java.util.UUID;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/4
 */
public class RandomUtil {

    public static String getSalt(){
        String salt = UUID.randomUUID().toString().replace("-", "").toLowerCase().substring(0,6);
        return salt;
    }

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
