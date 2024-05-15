package com.crio.starter.service;

import java.util.List;
import java.util.Optional;
import com.crio.starter.exchange.MemeIDResponseDto;
import com.crio.starter.exchange.MemeRequestDto;
import com.crio.starter.exchange.MemeResponseDto;


public interface MemesService {
 
    Optional<MemeIDResponseDto> saveMeme(MemeRequestDto meme);

    Optional<MemeResponseDto> getMemeById(String id);

    List<MemeResponseDto> getLastNMeme(int N);
}
