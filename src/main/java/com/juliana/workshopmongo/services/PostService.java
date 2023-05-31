package com.juliana.workshopmongo.services;

import com.juliana.workshopmongo.domain.Post;
import com.juliana.workshopmongo.domain.User;
import com.juliana.workshopmongo.dto.UserDTO;
import com.juliana.workshopmongo.repository.PostRepository;
import com.juliana.workshopmongo.repository.UserRepository;
import com.juliana.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle (String text){
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}

