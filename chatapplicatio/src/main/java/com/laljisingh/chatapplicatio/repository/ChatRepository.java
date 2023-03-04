package com.laljisingh.chatapplicatio.repository;

import com.laljisingh.chatapplicatio.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatHistory,Integer> {
}
