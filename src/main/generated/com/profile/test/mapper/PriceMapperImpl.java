package com.profile.test.mapper;

import com.profile.test.entity.PriceEntity;
import com.profile.test.model.PriceModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-29T08:34:14+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceModel toDto(PriceEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PriceModel.PriceModelBuilder priceModel = PriceModel.builder();

        priceModel.productId( entity.getProductId() );
        priceModel.brandId( entity.getBrandId() );
        priceModel.priceList( entity.getPriceList() );
        priceModel.startDate( entity.getStartDate() );
        priceModel.endDate( entity.getEndDate() );
        priceModel.price( entity.getPrice() );
        priceModel.currency( entity.getCurrency() );

        return priceModel.build();
    }
}
