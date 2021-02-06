package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.Message;
import com.sumutella.scorecalculation.repository.MessageRepository;
import com.sumutella.scorecalculation.service.MessageCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class MessageCommandServiceImpl implements MessageCommandService {
    private final MessageRepository messageRepository;

    public MessageCommandServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveSentMessage(Message message) {
        Message savedMessage = messageRepository.save(message);
        log.info("message saved to db: " + savedMessage);
    }
}
