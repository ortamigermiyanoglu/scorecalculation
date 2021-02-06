package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.Message;

public interface MessageCommandService {
    void saveSentMessage(Message message);
}
