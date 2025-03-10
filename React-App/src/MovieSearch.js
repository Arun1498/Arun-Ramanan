import React, { useState } from "react";

const MovieSearch = ({ onSearch }) => {
  const [searchTerm, setSearchTerm] = useState("");

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
    onSearch(e.target.value); 
  };

  return (
    <div className="mb-3">
      <input
        type="text"
        className="form-control"
        placeholder="Search movies..."
        value={searchTerm}
        onChange={handleSearch}
      />
    </div>
  );
};

export default MovieSearch;
