package com.mss.fashion.api.price;

import com.mss.fashion.api.price.dto.LowestPriceBrandDto;
import com.mss.fashion.api.price.dto.LowestPriceCategoryDto;
import com.mss.fashion.api.price.dto.PriceCategoryDto;
import com.mss.fashion.code.CategoryType;
import lombok.NonNull;

public interface PriceService {

    @NonNull LowestPriceCategoryDto getLowestPricesByCategory();

    @NonNull LowestPriceBrandDto getLowestPricesByBrand(long brandId);

    @NonNull PriceCategoryDto getPriceByCategoryName(CategoryType categoryType);
}
