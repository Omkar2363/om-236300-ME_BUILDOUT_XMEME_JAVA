package com.crio.starter.repositoryService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.crio.starter.data.MemeEntity;
import com.crio.starter.exceptions.DuplicateDataException;
import com.crio.starter.repository.MemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MemesRepositoryServiceImpl implements MemesRepositoryService{

    private static final String USER_SEQUENCE = "user_sequence";

    @Autowired
    private MemesRepository memesRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGenertor;


    

    @Override
    public List<MemeEntity> getLastNMemes(int N) {
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "createdDate")).limit(N);

        List<MemeEntity> memes = mongoTemplate.find(query, MemeEntity.class);

        return memes;
    }


    @Override
    public Optional<MemeEntity> getMemeById(String id) {
        return memesRepository.findById(id);
    }


    @Override
    public MemeEntity saveMeme(MemeEntity meme) throws DuplicateDataException {
        //Check is meme already exist or not in DataBase :
        if(!isMemeExist(meme)) {
            throw new DuplicateDataException();
        }

        meme.setId(sequenceGenertor.generateNextSequence(USER_SEQUENCE)+"");
        meme.setCreatedDate(new Date());

        MemeEntity savedMeme = memesRepository.save(meme);
        
        return savedMeme;
    }

    private boolean isMemeExist(MemeEntity meme){
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(meme.getName())
                                .and("url").is(meme.getUrl())
                                .and("caption").is(meme.getCaption()));

        List<MemeEntity> memes = mongoTemplate.find(query, MemeEntity.class);

        if(memes.isEmpty()) return true;

        return false;
                                
    }
    

    
}
