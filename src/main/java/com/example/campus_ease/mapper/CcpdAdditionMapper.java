package com.example.campus_ease.mapper;

import com.example.campus_ease.entity.CcpdInfoEntity;
import com.example.campus_ease.request.CcpdAdditionReq;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CcpdAdditionMapper {

    CcpdAdditionDto ccpdAdditionReqToCcpdAdditionDto(CcpdAdditionReq ccpdAdditionReq);

    CcpdInfoEntity ccpdAdditionDtoToCcpdAdditionInfo(CcpdAdditionDto ccpdAdditionDto);

    CcpdAdditionDto ccpdAdditionInfoToCcpdAdditionDto(CcpdInfoEntity ccpdInfoEntity);
}
