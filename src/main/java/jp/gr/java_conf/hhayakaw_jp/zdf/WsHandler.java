package jp.gr.java_conf.hhayakaw_jp.zdf;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author hhayakaw_jp
 *
 */
@Component
public class WsHandler extends TextWebSocketHandler {

    private Set<WebSocketSession> sessionPool = Collections.newSetFromMap(
            new ConcurrentHashMap<WebSocketSession, Boolean>());

    @Override
    public void afterConnectionEstablished(
            WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessionPool.add(session);
    }

    @Override
    public void afterConnectionClosed(
            WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        sessionPool.remove(session);
    }

    void sendTextMessage(TextMessage message) throws Exception {
        sessionPool.stream().parallel().forEach(e -> {
            try {
                e.sendMessage(message);
            } catch (Exception ex) {
                Utils.printException(ex);
            }
        });
    }

}
