package com.crio.starter.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.crio.starter.exchange.MemeIDResponseDto;
import com.crio.starter.exchange.MemeRequestDto;
import com.crio.starter.exchange.MemeResponseDto;
import com.crio.starter.service.MemesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MemesController {
    
    @Autowired
    private MemesService memesService;
    
    //End-Points :
    private static final String MEME_API_EndPoint = "/memes/";
    private static final String MEME_ID_API_EndPoint = "/memes/{id}";

    private static final int N = 100;

    //Get Methods :
    @GetMapping(MEME_API_EndPoint)
    public ResponseEntity<List<MemeResponseDto>> getLastNMemes(){

        List<MemeResponseDto> memes = memesService.getLastNMeme(N);

        return ResponseEntity.ok().body(memes);
    }


    @GetMapping(MEME_ID_API_EndPoint)
    public ResponseEntity<MemeResponseDto> getMemeById(@PathVariable(name = "id") long id){

        Optional<MemeResponseDto> meme = memesService.getMemeById(""+id);

        if(meme.isPresent())
            return ResponseEntity.ok().body(meme.get());

        return ResponseEntity.notFound().build();
    }

    //Post Methods :
    @PostMapping(MEME_API_EndPoint)
    public ResponseEntity<MemeIDResponseDto> saveMeme(@RequestBody(required = true) @Valid MemeRequestDto memeRequestDto){
        
        Optional<MemeIDResponseDto> memeIdDto = memesService.saveMeme(memeRequestDto);
        if(memeIdDto.isPresent()){
            return ResponseEntity.ok().body(memeIdDto.get());
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

}
