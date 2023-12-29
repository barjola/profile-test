package com.profile.test.mapper;

import com.profile.test.entity.PriceEntity;
import com.profile.test.model.PriceModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PriceModel toDto(PriceEntity entity);
}