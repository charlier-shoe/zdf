package jp.gr.java_conf.hhayakaw_jp.zdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * 
 * @author hhayakaw_jp
 *
 */
@RestController
@RequestMapping("/resources")
public class ZdfController {

    @Autowired
    private WsHandler handler;

    @RequestMapping(path = "/zun",
                    method = RequestMethod.GET)
    public String Zun() {
        System.out.println("Zun!");
        try {
            handler.sendTextMessage(new TextMessage("ズン！"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ズン！";
    }

    @RequestMapping(path = "/doco",
                    method = RequestMethod.GET)
    public String Doco() {
        System.out.println("Doco!");
        try {
            handler.sendTextMessage(new TextMessage("ドコ！"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ドコ！";
    }

}
