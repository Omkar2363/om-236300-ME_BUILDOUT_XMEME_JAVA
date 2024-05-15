package com.crio.starter.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exceptions.DuplicateDataException;
import com.crio.starter.exchange.MemeIDResponseDto;
import com.crio.starter.exchange.MemeRequestDto;
import com.crio.starter.exchange.MemeResponseDto;
import com.crio.starter.repositoryService.MemesRepositoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemesServiceImpl implements MemesService{

    @Autowired
    private MemesRepositoryService memesRepositoryService;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Optional<MemeIDResponseDto> saveMeme(MemeRequestDto memeInput) {
        Optional<MemeIDResponseDto> memeIdDto = Optional.empty();
        try{
            MemeEntity meme = modelMapper.map(memeInput, MemeEntity.class);
            MemeEntity savedMeme = memesRepositoryService.saveMeme(meme);
            MemeIDResponseDto idResponseDto = modelMapper.map(savedMeme, MemeIDResponseDto.class);
            memeIdDto = Optional.of(idResponseDto);
        }catch(DuplicateDataException e){
            // e.printStackTrace();
        }

        return memeIdDto;
    }

    @Override
    public Optional<MemeResponseDto> getMemeById(String id) {
        Optional<MemeEntity> meme = memesRepositoryService.getMemeById(id);
        Optional<MemeResponseDto> memeDto = Optional.empty();
        
        if(meme.isPresent()){
            MemeResponseDto mappedMeme = modelMapper.map(meme.get(), MemeResponseDto.class);
            memeDto = Optional.of(mappedMeme);
        }
        return memeDto;
    }

    @Override
    public List<MemeResponseDto> getLastNMeme(int N) {
        List<MemeEntity> memeEntities = memesRepositoryService.getLastNMemes(N);
        List<MemeResponseDto> memes = new ArrayList<>();

        for(MemeEntity meme : memeEntities){
            MemeResponseDto memeResponseDto = modelMapper.map(meme, MemeResponseDto.class);
            memes.add(memeResponseDto);
        }

        return memes;
    }
    
}