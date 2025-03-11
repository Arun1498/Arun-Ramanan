import React from "react";
import "./App.css";

const MovieCard = ({ movie }) => {
  return (
    <div className="col-md-3 col-sm-6">
      <div
        className="card mb-4"
        style={{
          width: "220px",
          height: "auto",
          backgroundColor: "#333",
          color: "#fff",
          borderRadius: "10px",
          boxShadow: "2px 4px 12px rgba(0, 0, 0, 0.6)",
        }}
      >
        <img
          src={movie.Poster}
          className="card-img-top"
          alt={movie.Title}
          style={{
            height: "270px",
            objectFit: "cover",
            borderTopLeftRadius: "10px",
            borderTopRightRadius: "10px",
          }}
        />
        <div
          className="card-body"
          style={{
            padding: "10px",
            textAlign: "center",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-between",
          }}
        >
          <h5 className="card-title" style={{ fontSize: "16px" }}>
            {movie.Title}
          </h5>
          <p className="card-text" style={{ fontSize: "14px", marginBottom: "5px" }}>
            Year: {movie.Year}
          </p>
          <p
            className="card-text"
            style={{
              fontStyle: "italic",
              fontSize: "12px",
              color: "#ccc",
              whiteSpace: "normal", // Allow the review to wrap normally
            }}
          >
            Review: {movie.Review}
          </p>
        </div>
      </div>
    </div>
  );
};

export default MovieCard;
