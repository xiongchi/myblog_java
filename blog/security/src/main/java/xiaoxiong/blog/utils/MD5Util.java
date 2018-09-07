package xiaoxiong.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/4
 */
public class MD5Util {

    private static Logger log = LoggerFactory.getLogger(MD5Util.class);

    public static String md5Password(String password, String salt) {
        String dbPassword = password + salt;
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(dbPassword.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("加密出错");
            return "";
        }
    }

}
