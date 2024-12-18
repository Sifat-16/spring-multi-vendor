package com.wakil.spring_multi_vendor.requests.product;

import com.wakil.spring_multi_vendor.validator.NotBlankIfPresent.NotBlankIfPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {

    @NotBlankIfPresent(message = "Name can not be blank if it's not null")
    private String name;

    private String description;
}
