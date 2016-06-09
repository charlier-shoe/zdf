package jp.gr.java_conf.hhayakaw_jp.zdf;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author hhayakaw_jp
 *
 */
@RestController
@RequestMapping("/zdf")
public class ZdfController {

    @RequestMapping(path = "/zun",
                    method = RequestMethod.GET)
    public String Zun() {
        System.out.println("Zun!");
        return "ズン！";
    }

    @RequestMapping(path = "/doco",
                    method = RequestMethod.GET)
    public String Doco() {
        System.out.println("Doco!");
        return "ドコ！";
    }

}
