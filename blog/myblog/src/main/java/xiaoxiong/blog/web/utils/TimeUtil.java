package xiaoxiong.blog.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/23
 */
public class TimeUtil {

    public static String nowDate() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return sdf.format(d);
    }

    public static String nowDate(String pattern){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(d);
    }

    public static void main(String[] args) {
        System.out.println(nowDate());
        System.out.println(nowDate("yyyy-MM-dd"));
    }
}
