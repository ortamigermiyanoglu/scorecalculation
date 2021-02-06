package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.TestObjectFactory;
import com.sumutella.scorecalculation.repository.ScoreSegmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScoreSegmentCommandServiceImplTest {

    ScoreSegmentQueryServiceImpl service;
    @Mock
    private ScoreSegmentRepository scoreSegmentRepository;

    @Before
    public void setUp() throws Exception {
        service = new ScoreSegmentQueryServiceImpl(scoreSegmentRepository);
    }

    @Test
    public void calculateScoreSegment() {
//        Mockito.when(scoreSegmentRepository.existsByIdentityNumber(Mockito.anyLong())).thenReturn(true);
        Mockito.when(scoreSegmentRepository.findByIdentityNumber(Mockito.anyLong())).thenReturn(TestObjectFactory.scoreSegment());

        service.getUserScoreSegment(22906948011L);

        Mockito.verify(scoreSegmentRepository, Mockito.times(1)).findByIdentityNumber(Mockito.anyLong());

    }
}