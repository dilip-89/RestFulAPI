package org.restfulapi.addObjectSerialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Data {

    private Integer year;
    private double price;
    private String cpuModel;
    private String hardDiskSize;


    @JsonCreator
    public Data(@JsonProperty("year") Integer year, @JsonProperty("price") double price, @JsonProperty("CPU model") String cpuModel
            ,@JsonProperty("Hard disk size") String hardDiskSize) {
        this.year = year;
        this.price = price;
        this.cpuModel = cpuModel;
        this.hardDiskSize = hardDiskSize;
    }
}

