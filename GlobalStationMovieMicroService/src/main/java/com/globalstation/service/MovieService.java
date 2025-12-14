package com.globalstation.service;


import com.globalstation.entity.MovieModel;
import com.globalstation.exception.MovieNotFound;
import com.globalstation.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public List<MovieModel> getAllMovie() {
        return movieRepository.findAll();
    }

    public MovieModel getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(
                () -> new MovieNotFound("Movie not found for given id " + id));
    }

    public List<MovieModel> getMovieByName(String name) {
        return movieRepository.findMovieModelByMovieTitleContaining(name);
    }
    public MovieModel saveMovie(MovieModel movieModel) {
        return movieRepository.save(movieModel);
    }


//        Set<ActorModel> actorModelSet = new HashSet<>();
//        for (ActorDTO actorDTO : movieDTO.getActors()) {
//            Optional<ActorModel> optionalActor = actorRepository.findByNameAndAgeAndGender(
//                    actorDTO.getFirstName(), actorDTO.getAge(), actorDTO.getGender());
//            ActorModel actorModel;
//            if (optionalActor.isPresent()) {
//                actorModel = optionalActor.get();
//            } else {
//                actorModel = ActorModel.getInstance(0, actorDTO.getFirstName(), actorDTO.getLastName(),
//                        actorDTO.getGender(), actorDTO.getAge(), actorDTO.getMovies().stream().map(movieDTO1 ->
//                                 MovieModel.getInstance(movieDTO1.getMovieId(),movieDTO.getMovieTitle(),movieDTO.getMovieCost(),movieDTO.getMovieYear(),movieDTO.getActors())));
////
////
////                        actorDTO.getFirstName(), actorDTO.getLastName(),
////                        actorDTO.getAge(), actorDTO.getGender(), actorDTO.getMovies());
//            }
//            actorModelSet.add(actorModel);
//        }


    public MovieModel updateMovie(MovieModel movieModel) {
        MovieModel movieModel1 = movieRepository.findById(movieModel.getMovieId()).orElseThrow(
                () -> new MovieNotFound("Movie not found for given id " + movieModel.getMovieId()));
        movieModel1.setMovieTitle(movieModel.getMovieTitle());
        movieModel1.setMovieYear(movieModel.getMovieYear());
        movieModel1.setMovieCost(movieModel.getMovieCost());

        return movieRepository.save(movieModel1);
    }

    public MovieModel deleteMovie(int id) {
        MovieModel movieModel = movieRepository.findById(id).orElseThrow(
                () -> new MovieNotFound("Movie not found for given id " + id));
        movieRepository.deleteById(movieModel.getMovieId());

        return movieModel;
    }

}
