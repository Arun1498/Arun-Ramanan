import React, { useState, useEffect } from "react";
import MovieCard from "./MovieCard1";
import MovieSearch from "./MovieSearch";
import MovieForm from "./MovieForm";

const MovieReview = () => {
  const [movies, setMovies] = useState([]);
  const [filteredMovies, setFilteredMovies] = useState([]); 

  
  const fetchMovies = async () => {
    try {
      const response = await fetch("http://localhost:5000/movies");
      const data = await response.json();
      setMovies(data);
      setFilteredMovies(data); 
    } catch (error) {
      console.error("Error fetching movies:", error);
    }
  };

  
  const addMovie = async (newMovie) => {
    try {
      const response = await fetch("http://localhost:5000/movies", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newMovie),
      });

      if (response.ok) {
        const addedMovie = await response.json();
        setMovies([...movies, addedMovie]); 
        setFilteredMovies([...movies, addedMovie]); 
      }
    } catch (error) {
      console.error("Error adding movie:", error);
    }
  };

  
  const handleSearch = (query) => {
    if (!query) {
      setFilteredMovies(movies);
    } else {
      const filtered = movies.filter((movie) =>
        movie.Title.toLowerCase().includes(query.toLowerCase())
      );
      setFilteredMovies(filtered);
    }
  };

  useEffect(() => {
    fetchMovies();
  }, []);

  return (
    <div className="container">
      <h1 className="text-center my-4">Movie Review Site</h1>
      <MovieSearch onSearch={handleSearch} />
      <MovieForm onAddMovie={addMovie} />
      <div className="row">
        {filteredMovies.map((movie) => (
          <MovieCard key={movie.id} movie={movie} />
        ))}
      </div>
    </div>
  );
};

export default MovieReview;
