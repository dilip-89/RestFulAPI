package org.restfulapi.updateObjectSerialization;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class updateObjectInputDTO {
    public String name;
    public data data;

    @JsonCreator
    public updateObjectInputDTO(@JsonProperty("name") String name, @JsonProperty("data") data data) {
        this.name = name;
        this.data = data;
    }
}
