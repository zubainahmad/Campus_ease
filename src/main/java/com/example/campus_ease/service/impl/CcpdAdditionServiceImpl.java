package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.CcpdInfoRepo;
import com.example.campus_ease.entity.CcpdInfoEntity;
import com.example.campus_ease.mapper.CcpdAdditionMapper;
import com.example.campus_ease.service.CcpdAdditionService;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import org.springframework.stereotype.Service;

@Service
public class CcpdAdditionServiceImpl implements CcpdAdditionService {

    private CcpdAdditionMapper ccpdAdditionMapper;

    private CcpdInfoRepo ccpdInfoRepo;

    public CcpdAdditionServiceImpl(CcpdAdditionMapper ccpdAdditionMapper, CcpdInfoRepo ccpdInfoRepo) {
        this.ccpdAdditionMapper = ccpdAdditionMapper;
        this.ccpdInfoRepo = ccpdInfoRepo;
    }

    @Override
    public CcpdAdditionDto addCcpd(CcpdAdditionDto ccpdAdditionDto) {
        CcpdInfoEntity ccpdInfoEntity = ccpdAdditionMapper.ccpdAdditionDtoToCcpdAdditionInfo(ccpdAdditionDto);
        CcpdInfoEntity savedCcpdInfoEntity = ccpdInfoRepo.save(ccpdInfoEntity);
        CcpdAdditionDto returnValue = ccpdAdditionMapper.ccpdAdditionInfoToCcpdAdditionDto(savedCcpdInfoEntity);
        return returnValue;
    }
}
