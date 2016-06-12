package jp.gr.java_conf.hhayakaw_jp.zdf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hhayakaw_jp
 *
 */
@Controller
public class DisplayController {

    @RequestMapping("/")
    public String showTopPage() {
        return "index";
    }

}
