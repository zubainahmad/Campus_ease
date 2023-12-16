package com.example.campus_ease.management.impl;

import com.example.campus_ease.management.CcpdAdditionManagement;
import com.example.campus_ease.service.CcpdAdditionService;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class CcpdAdditionManagementImpl implements CcpdAdditionManagement {

    private CcpdAdditionService ccpdAdditionService;

    public CcpdAdditionManagementImpl(CcpdAdditionService ccpdAdditionService) {
        this.ccpdAdditionService = ccpdAdditionService;
    }

    @Override
    public CcpdAdditionDto addCcpd(CcpdAdditionDto ccpdAdditionDto) {
        return ccpdAdditionService.addCcpd(ccpdAdditionDto);
    }
}
