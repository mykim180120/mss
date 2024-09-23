package com.mss.fashion.api.price;

import com.mss.fashion.api.price.dto.LowestPriceBrandDto;
import com.mss.fashion.api.price.dto.LowestPriceByBrandGetResponse;
import com.mss.fashion.api.price.dto.LowestPriceByCategoryGetResponse;
import com.mss.fashion.api.price.dto.LowestPriceCategoryDto;
import com.mss.fashion.api.price.dto.PriceByCategoryGetResponse;
import com.mss.fashion.api.price.dto.PriceCategoryDto;
import com.mss.fashion.code.CategoryType;
import com.mss.fashion.common.annotation.VersionControllerV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@VersionControllerV1
@RequiredArgsConstructor
@Validated
public class PriceController {

    private final PriceService priceService;

    @GetMapping("/prices/category")
    ResponseEntity<LowestPriceByCategoryGetResponse> getLowestPricesByAllCategory() {
        final LowestPriceCategoryDto lowestPriceCategoryDto = this.priceService.getLowestPricesByCategory();
        return ResponseEntity.ok(
                new LowestPriceByCategoryGetResponse(
                        lowestPriceCategoryDto.getTotalPrice(),
                        lowestPriceCategoryDto.getLowestPriceCategoryDtoList()));
    }

    @GetMapping("/prices/brand/{id}")
    ResponseEntity<LowestPriceByBrandGetResponse> getLowestPricesByBrandId(@PathVariable final long id) {
        final LowestPriceBrandDto lowestPriceBrandDto = this.priceService.getLowestPricesByBrand(id);
        return ResponseEntity.ok(
                new LowestPriceByBrandGetResponse(
                        lowestPriceBrandDto.getTotalPrice(),
                        lowestPriceBrandDto.getLowestPriceBrandDtoList()));
    }

    @GetMapping("/prices/{name}")
    ResponseEntity<PriceByCategoryGetResponse> getPricesByCategoryName(@PathVariable final String name) {
        final PriceCategoryDto priceCategoryDto = this.priceService.getPriceByCategoryName(CategoryType.valueOf(name));
        return ResponseEntity.ok(
                new PriceByCategoryGetResponse(
                        priceCategoryDto.getCategoryName(),
                        priceCategoryDto.getGreatestPriceProduct(),
                        priceCategoryDto.getLowestPriceProduct()));
    }
}
