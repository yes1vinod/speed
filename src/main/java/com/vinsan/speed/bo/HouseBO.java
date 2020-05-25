package com.vinsan.speed.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HouseBO {
    private String longitude;
    private String latitude;
    @JsonProperty("housing_median_age")
    private String housingMedianAge;
    @JsonProperty("total_rooms")
    private String totalRooms;
    @JsonProperty("total_bedrooms")
    private String totalBedrooms;
    @JsonProperty("population")
    private String population;
    private String households;
    @JsonProperty("median_income")
    private String medianIncome;
    @JsonProperty("median_house_value")
    private String medianHouseValue;
    @JsonProperty("ocean_proximity")
    private String oceanProximity;


}
