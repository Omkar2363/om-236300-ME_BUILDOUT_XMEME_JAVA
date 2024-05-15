package com.crio.starter.repositoryService;

import java.util.List;
import java.util.Optional;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exceptions.DuplicateDataException;


public interface MemesRepositoryService {
    
    Optional<MemeEntity> getMemeById(String id);

    List<MemeEntity> getLastNMemes(int N);

    MemeEntity saveMeme(MemeEntity meme) throws DuplicateDataException; 
}

    
