package com.crio.starter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "memes_userSequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Memes_userSequence {

    @Id
    private String id;
    private long seq;
    
}