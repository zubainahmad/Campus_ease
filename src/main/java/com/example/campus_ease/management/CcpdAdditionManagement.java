package com.example.campus_ease.management;

import com.example.campus_ease.response.CcpdRes;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;

public interface CcpdAdditionManagement {

    public CcpdAdditionDto addCcpd(CcpdAdditionDto ccpdAdditionDto);

    CcpdRes getCcpd(String userID);
}
