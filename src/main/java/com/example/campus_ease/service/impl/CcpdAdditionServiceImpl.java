package com.example.campus_ease.service.impl;

import com.example.campus_ease.dao.CcpdInfoRepo;
import com.example.campus_ease.entity.CcpdInfoEntity;
import com.example.campus_ease.mapper.CcpdAdditionMapper;
import com.example.campus_ease.response.CcpdRes;
import com.example.campus_ease.service.CcpdAdditionService;
import com.example.campus_ease.shared.dto.CcpdAdditionDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class CcpdAdditionServiceImpl implements CcpdAdditionService {

    private CcpdAdditionMapper ccpdAdditionMapper;

    private CcpdInfoRepo ccpdInfoRepo;

    private EntityManager entityManager;

    public CcpdAdditionServiceImpl(CcpdAdditionMapper ccpdAdditionMapper, CcpdInfoRepo ccpdInfoRepo, EntityManager entityManager) {
        this.ccpdAdditionMapper = ccpdAdditionMapper;
        this.ccpdInfoRepo = ccpdInfoRepo;
        this.entityManager = entityManager;
    }

    @Override
    public CcpdAdditionDto addCcpd(CcpdAdditionDto ccpdAdditionDto) {
        CcpdInfoEntity ccpdInfoEntity = ccpdAdditionMapper.ccpdAdditionDtoToCcpdAdditionInfo(ccpdAdditionDto);
        CcpdInfoEntity savedCcpdInfoEntity = ccpdInfoRepo.save(ccpdInfoEntity);
        CcpdAdditionDto returnValue = ccpdAdditionMapper.ccpdAdditionInfoToCcpdAdditionDto(savedCcpdInfoEntity);
        return returnValue;
    }

    @Override
    public CcpdRes getCcpd(String userID) {
        String userId = ccpdInfoRepo.userCheck(userID);
        if(Objects.isNull(userId)){
            CcpdInfoEntity ccpdInfoEntity = ccpdInfoRepo.findById(userID);
            CcpdRes ccpdRes = new CcpdRes();
            ccpdRes.setCcpd_id(ccpdInfoEntity.getUserId());
            ccpdRes.setEmail(ccpdInfoEntity.getEmail());
            ccpdRes.setFirst_name(ccpdInfoEntity.getFirstName());
            ccpdRes.setLast_name(ccpdInfoEntity.getLastName());
            ccpdRes.setCompany_name(new ArrayList<>());
            return ccpdRes;
        }
        String query = "WITH pika AS (SELECT ce.user_id AS user_id,email,first_name,last_name,company_name FROM \"public\".ccpd_info_entity AS ce JOIN \"public\".job_posted_entity AS je \n" +
                "ON ce.user_id = je.user_id WHERE je.user_id = :id\n" +
                "GROUP BY(ce.user_id,ce.email,ce.first_name,ce.last_name,je.company_name))\n" +
                "SELECT COALESCE(JSON_BUILD_OBJECT('ccpd_id',user_id, 'email',email,'first_name', first_name, 'last_name',last_name,'company_name',ARRAY_AGG(company_name)),null) FROM pika GROUP BY (user_id,email,first_name,last_name)";
        NativeQuery nativeQuery = (NativeQuery) entityManager.createNativeQuery(query);
        nativeQuery.setParameter("id", userID);
        Object result = nativeQuery.getSingleResult();
        ObjectMapper objectMapper = new ObjectMapper();
        CcpdRes ccpdRes;
        try {
             ccpdRes = objectMapper.readValue(result.toString(), CcpdRes.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return ccpdRes;
    }
}
