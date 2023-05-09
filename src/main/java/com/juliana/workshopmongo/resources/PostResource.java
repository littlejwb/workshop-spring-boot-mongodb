package com.juliana.workshopmongo.resources;

import com.juliana.workshopmongo.domain.Post;
import com.juliana.workshopmongo.dto.UserDTO;
import com.juliana.workshopmongo.resources.util.URL;
import com.juliana.workshopmongo.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    private PostService service;

    public PostResource(PostService service) {
        this.service = service;
    }

     @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text){
        text = URL.decodeParam(text);
        List<Post> list =  service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
