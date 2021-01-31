package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.dto.IdCodeDisplayValueDTO;
import com.sumutella.scorecalculation.repository.DomainValueRepository;
import com.sumutella.scorecalculation.service.DomainValueQueryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class DomainValueQueryServiceImpl implements DomainValueQueryService {
    private final DomainValueRepository domainValueRepository;
    private final ModelMapper modelMapper;

    public DomainValueQueryServiceImpl(DomainValueRepository domainValueRepository, ModelMapper modelMapper) {
        this.domainValueRepository = domainValueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DomainValue getIncomeTranche(Integer incomeTrancheCode) {
        Optional<DomainValue> optionalDomainValue = domainValueRepository.findDomainValueByCode(incomeTrancheCode);
        if (optionalDomainValue.isPresent()){
            return optionalDomainValue.get();
        }
        return null;
    }

    @Override
    public List<IdCodeDisplayValueDTO> getAllIncomeTranches(String domainValueTypeCode) {
        PropertyMap<DomainValue, IdCodeDisplayValueDTO> incomeTrancheMap = new PropertyMap <DomainValue, IdCodeDisplayValueDTO>() {
            protected void configure() {
                map().setDisplayValue(source.getDescription());
            }
        };
        modelMapper.addMappings(incomeTrancheMap);
        List<DomainValue> incomeTrancheList = domainValueRepository.findAllByDomainValueTypeCode("INCOME_TRANCHES");
        return incomeTrancheList.stream().map(incomeTranche -> modelMapper.map(incomeTranche,IdCodeDisplayValueDTO.class)).collect(Collectors.toList());
    }
}
