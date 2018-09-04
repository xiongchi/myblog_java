package xiaoxiong.blog.utils;


import xiaoxiong.blog.constants.ResultEnum;
import xiaoxiong.blog.result.ResultMsg;

public class ResultUtil {

    /**
     * 成功
     * @param o
     * @return
     */
    public static ResultMsg success(Object o){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(ResultEnum.SUCCESS.getCode());
        resultMsg.setMessage(ResultEnum.SUCCESS.getMsg());
        resultMsg.setObj(o);
        return resultMsg;
    }

    /**
     * 失败
     * @return
     */
    public static ResultMsg error(){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(ResultEnum.ERROR.getCode());
        resultMsg.setMessage(ResultEnum.ERROR.getMsg());
        return resultMsg;
    }

    public static ResultMsg error(int code, String msg){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(code);
        resultMsg.setMessage(msg);
        return resultMsg;
    }

}
