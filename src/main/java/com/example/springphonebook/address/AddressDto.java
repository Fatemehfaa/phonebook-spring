package com.example.springphonebook.address;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private String cityName;
}
