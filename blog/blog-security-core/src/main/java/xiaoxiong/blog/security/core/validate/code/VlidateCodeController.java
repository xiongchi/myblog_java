package xiaoxiong.blog.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static xiaoxiong.blog.security.core.constants.SecurityConstants.SEESION_KEY;

/**
 * @Author: XiongChi
 * @Description:
 * @Date: 2018/7/10
 */
@RestController
public class VlidateCodeController {

    /**
     * session
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    @Qualifier("imageCodeGenerator")
    private ValidateCodeGenerator imageCodeGenerator;

    @GetMapping("/code/image")
    public void createCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        ImageCode imageCode = (ImageCode) imageCodeGenerator.generator(new ServletWebRequest(request));
        sessionStrategy.setAttribute(new ServletWebRequest(request), SEESION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }


}
