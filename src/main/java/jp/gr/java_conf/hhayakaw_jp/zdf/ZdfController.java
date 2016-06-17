package jp.gr.java_conf.hhayakaw_jp.zdf;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;

/**
 * @author hhayakaw_jp
 *
 */
@RestController
@RequestMapping("/resources")
public class ZdfController {

    @Autowired
    private WsHandler handler;

    private LinkedList<Boolean> zd = new LinkedList<Boolean>();

    @RequestMapping(path = "/zun",
                    method = RequestMethod.GET)
    public String Zun() {
        try {
            zd.addFirst(true);
            handler.sendTextMessage(new TextMessage("ズン！"));
        } catch (Exception e) {
            Utils.printException(e);
        }
        return "ズン！";
    }

    @RequestMapping(path = "/doco",
                    method = RequestMethod.GET)
    public String Doco() {
        try {
            zd.addFirst(false);
            handler.sendTextMessage(new TextMessage("ドコ！"));
            if (zd.get(1) && zd.get(2) && zd.get(3)) {
                Thread.sleep(1000);
                handler.sendTextMessage(new TextMessage("キヨシ！"));
                return "キヨシ！";
            }
        } catch (Exception e) {
            Utils.printException(e);
        }
        return "ドコ！";
    }

}
