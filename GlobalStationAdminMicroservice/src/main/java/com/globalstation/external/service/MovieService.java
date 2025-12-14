package com.globalstation.external.service;


import com.globalstation.entity.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "global-station-movie-service")
public interface MovieService {

    @GetMapping("/api/v0/movie")
    public List<MovieDTO> getAllMovie();

}
