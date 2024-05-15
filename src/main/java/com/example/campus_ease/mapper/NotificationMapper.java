package com.example.campus_ease.mapper;

import com.example.campus_ease.entity.NotificationInfoEntity;
import com.example.campus_ease.response.NotificationResponse;
import com.example.campus_ease.shared.dto.NotificationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    NotificationInfoEntity notificationDtoToNotificationInfoEntity(NotificationDto notificationDto);

    NotificationResponse notificationDtoToNotificationResponse(NotificationDto notificationData);

    NotificationDto notificationInfoEntityToNotificationDto(NotificationInfoEntity notificationInfoEntity);
}
