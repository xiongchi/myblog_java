package xiaoxiong.blog.services;

import xiaoxiong.blog.request.AdminRequest;
import xiaoxiong.blog.response.AdminResponse;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/9/3
 */
public interface IAdminService {

    AdminResponse registerService(AdminRequest adminRequest);

}
