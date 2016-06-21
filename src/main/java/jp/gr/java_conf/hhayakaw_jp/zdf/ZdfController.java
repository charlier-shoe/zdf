package jp.gr.java_conf.hhayakaw_jp.zdf;

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

    private int zd = 0x00;

    @RequestMapping(path = "/zun",
                    method = RequestMethod.GET)
    public String Zun() {
        try {
            zd = zd << 1 | 0x01;
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
            zd = zd << 1;
            handler.sendTextMessage(new TextMessage("ドコ！"));
            if ((zd & 0x1E) == 0x1E) {
                Thread.sleep(800);
                handler.sendTextMessage(new TextMessage("キヨシ！"));
                return "キヨシ！";
            }
        } catch (Exception e) {
            Utils.printException(e);
        }
        return "ドコ！";
    }

}
