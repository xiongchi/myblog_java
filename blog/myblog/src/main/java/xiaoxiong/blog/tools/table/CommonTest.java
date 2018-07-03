package xiaoxiong.blog.tools.table;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/2
 */
public class CommonTest {
    public static void main(String[] args) {
        String s = JSONObject.toJSONString(new Date());
        System.out.println(s);
    }
}
