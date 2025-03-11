import React, { useState } from "react";

const MovieForm = ({ onAddMovie }) => {
  const [title, setTitle] = useState("");
  const [year, setYear] = useState("");
  const [poster, setPoster] = useState("");
  const [review, setReview] = useState("");  
  const [error, setError] = useState(""); 

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!title || !year || !poster || !review) {  
      setError("All fields are required!");
      return;
    }

    const newMovie = {
      Title: title,
      Year: year,
      Poster: poster,
      Review: review,  
    };

    onAddMovie(newMovie);

    setTitle("");
    setYear("");
    setPoster("");
    setReview("");  
    setError(""); 
  };

  return (
    <div className="card p-4 my-4 shadow-lg" style={{ backgroundColor: "#333", color: "#fff" }}>
      <h4 className="text-center mb-4">Add a New Movie</h4>
      {error && <div className="alert alert-danger">{error}</div>} 
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Movie Title</label>
          <input
            type="text"
            className="form-control"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder="Enter movie title"
            style={{ backgroundColor: "#444", color: "#fff", borderColor: "#555" }}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Release Year</label>
          <input
            type="text"
            className="form-control"
            value={year}
            onChange={(e) => setYear(e.target.value)}
            placeholder="Enter release year"
            style={{ backgroundColor: "#444", color: "#fff", borderColor: "#555" }}
          />
        </div>

        <div className="mb-3">
          <label className="form-label">Poster URL</label>
          <input
            type="text"
            className="form-control"
            value={poster}
            onChange={(e) => setPoster(e.target.value)}
            placeholder="Enter poster image URL"
            style={{ backgroundColor: "#444", color: "#fff", borderColor: "#555" }}
          />
        </div>

        {}
        <div className="mb-3">
          <label className="form-label">Review</label>
          <textarea
            className="form-control"
            value={review}
            onChange={(e) => setReview(e.target.value)}
            placeholder="Enter a review for the movie"
            style={{ backgroundColor: "#444", color: "#fff", borderColor: "#555", minHeight: "100px" }}
          />
        </div>

        <button 
          type="submit" 
          className="btn btn-success w-100" 
          style={{ backgroundColor: "#28a745", borderColor: "#28a745" }}
        >
          Add Movie
        </button>
      </form>
    </div>
  );
};

export default MovieForm;
