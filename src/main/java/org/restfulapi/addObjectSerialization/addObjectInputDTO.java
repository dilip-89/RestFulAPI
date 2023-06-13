package org.restfulapi.addObjectSerialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class addObjectInputDTO {
    public String name;
    public Data data;

    @JsonCreator
    public addObjectInputDTO(@JsonProperty("name") String name, @JsonProperty("data") Data data) {
        this.name = name;
        this.data = data;
    }
}
