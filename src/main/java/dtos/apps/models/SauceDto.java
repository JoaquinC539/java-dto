package dtos.apps.models;

import lombok.Data;

@Data
public class SauceDto {

    private Integer id;
    private String name;
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SauceDto(){}
}
