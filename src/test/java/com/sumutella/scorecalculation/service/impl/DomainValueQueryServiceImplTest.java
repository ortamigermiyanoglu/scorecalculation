package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.TestObjectFactory;
import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.repository.DomainValueRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class DomainValueQueryServiceImplTest {

    DomainValueQueryServiceImpl service;
    @Mock
    private DomainValueRepository domainValueRepository;
    @Mock
    private ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        service = new DomainValueQueryServiceImpl(domainValueRepository, modelMapper);
    }

    @Test
    public void getIncomeTranche() {
        Optional<DomainValue> optionalIncomeTranche = Optional.of(TestObjectFactory.incomeTranche());

        Mockito.when(domainValueRepository.findDomainValueByCode(Mockito.anyInt())).thenReturn(optionalIncomeTranche);

        DomainValue actual = service.getIncomeTranche(2);
        Assert.assertEquals(TestObjectFactory.incomeTranche(), actual);
    }
}