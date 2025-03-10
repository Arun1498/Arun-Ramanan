import React from "react";
import "./App.css";

const MovieCard = ({ movie }) => {
  return (
    <div className="col-md-3 col-sm-6">
      <div className="card mb-4" style={{ width: "220px", height: "350px", backgroundColor: "#333", color: "#fff", borderRadius: "10px", boxShadow: "2px 4px 12px rgba(0, 0, 0, 0.6)" }}>
        <img src={movie.Poster} className="card-img-top" alt={movie.Title} style={{ height: "270px", objectFit: "cover", borderTopLeftRadius: "10px", borderTopRightRadius: "10px" }} />
        <div className="card-body" style={{ padding: "10px", textAlign: "center" }}>
          <h5 className="card-title">{movie.Title}</h5>
          <p className="card-text">Year: {movie.Year}</p>
        </div>
      </div>
    </div>
  );
};

export default MovieCard;
