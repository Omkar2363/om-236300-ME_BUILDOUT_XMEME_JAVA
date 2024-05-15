package com.crio.starter.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemeRequestDto {
    
    @NotNull
    private String name;
    
    @NotNull
    private String url;

    @NotNull
    private String caption;
}
