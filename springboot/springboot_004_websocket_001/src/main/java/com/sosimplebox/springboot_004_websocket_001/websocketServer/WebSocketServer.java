package com.sosimplebox.springboot_004_websocket_001.websocketServer;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@ServerEndpoint("/websocket/{sid}")
@Component
public class WebSocketServer {
	
	static Logger LOGGER = LoggerFactory.getLogger(WebSocketServer.class);
	
	static AtomicInteger onlineCount = new AtomicInteger(0);
	
	static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
	
	Session session;
	
	String sid;
	
	@OnOpen
	public void onOpen(Session session, @PathParam("sid") String sid) {
		this.session = session;
		this.sid = sid;
		webSocketSet.add(this);
		onlineCount.addAndGet(1);
		LOGGER.info(String.format("有新窗口开始监听: %s, 当前在线人数: %d", sid, onlineCount.get()));
	}
	
	@OnClose
	public void onClose() {
		webSocketSet.remove(this);
		onlineCount.addAndGet(-1);
		LOGGER.info(String.format("有窗口关闭, 当前在线人数为[%d]", onlineCount.get()));
	}
	
	@OnMessage
	public void onMessage(Session session, String message) {
		LOGGER.info(String.format("收到来自窗口[%S]的消息[%s]", sid, message));
		for(WebSocketServer item : webSocketSet) {
			try {
				item.sendMessage(message);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		LOGGER.error("发生错误");
		error.printStackTrace();
	}
	
	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}
	
	public static void sendInfo(String message, @PathParam("sid") String sid) {
		LOGGER.info(String.format("推送消息[%s]到窗口[%s]", message, sid));
		for(WebSocketServer item : webSocketSet) {
			try {
				if (sid == null) {
					item.sendMessage(message);
				}else if (item.sid.equals(sid)) {
					item.sendMessage(message);
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
