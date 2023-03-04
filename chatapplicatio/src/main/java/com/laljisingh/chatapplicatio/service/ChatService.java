package com.laljisingh.chatapplicatio.service;

import com.laljisingh.chatapplicatio.model.ChatHistory;
import com.laljisingh.chatapplicatio.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    ChatRepository chatRepository;
    public int sendMessage(ChatHistory chat) {
        ChatHistory save = chatRepository.save(chat);
        return save.getChatId();
    }
}
