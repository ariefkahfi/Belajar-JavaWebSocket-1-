package com.arief.socketserver;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/web-socket")
public class ChatServerEndpoint {

    Session session;

//     Set<ChatServerEndpoint> sessionSet = new CopyOnWriteArraySet<ChatServerEndpoint>();
     List<Session> listSession = new CopyOnWriteArrayList<>();


    @OnOpen
    public void onOpen(Session session){
        listSession.add(session);
        System.out.println("onOpen");
        System.out.println(session);
    }

    @OnMessage
    public void onMessage(Session session , String message) {
       System.out.println("onMessage");
       broadcastMessage(session,message);
       cekSessions();
    }
    @OnError
    public void onError(Session session , Throwable thr){
        System.out.println("onError");
    }
    @OnClose
    public void onClose(){
        System.out.println("onClose");
    }

    private void cekSessions(){
       for(Session s : listSession){
           System.err.println("Sesi CekAktif : " + s);
       }
    }

    private  void broadcastMessage(Session openSession,String message){
        for (Session s : openSession.getOpenSessions()){
            if(s.isOpen()){
                System.err.println("Sesi broadcastMessage : " + s);
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            }
        }
    }


