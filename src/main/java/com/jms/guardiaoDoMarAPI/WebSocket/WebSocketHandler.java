package com.jms.guardiaoDoMarAPI.WebSocket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class WebSocketHandler extends AbstractWebSocketHandler {

    private static Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());
    }
    
    public static void enviarMensagemParaTodos(String message) throws Exception {
        for (WebSocketSession session : sessions.values()) {
            try {
            	session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                System.out.println("Erro ao enviar mensagem para a sessão: " + session.getId());
            }
        }
    }
}
