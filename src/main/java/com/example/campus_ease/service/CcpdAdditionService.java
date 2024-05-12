package com.example.campus_ease.service;

import com.example.campus_ease.response.CcpdRes;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;

public interface CcpdAdditionService {

     CcpdAdditionDto addCcpd(CcpdAdditionDto ccpdAdditionDto);

    CcpdRes getCcpd(String userID);
}
