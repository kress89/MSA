import React, { useState } from "react";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Movie from "./Movie";
import "bootstrap/dist/css/bootstrap.min.css";

function SearchBar() {
  const searchRef = React.createRef<any>();
  const [movies, setMovies] = useState([] as Object[]);
  const movieRef = React.createRef<any>();
  const showRef = React.createRef<any>();

  const handleSearch = async () => {
    if (!searchRef.current.value) {
      setMovies([]);
    } else {
      setMovies([]);
      const tip =
        movieRef.current.checked && !showRef.current.checked ? "movie" : "show";
      let response = await fetch(
        `http://localhost:8070/api/movie/dohvati?title=${escape(
          searchRef.current.value
        )}&type=${tip}`
      );
      let json = await response.json();
      for (let i = 0; i < json.length; i++) {
        let data = json[i];
        setMovies((movies) => [...movies, <Movie data={data} />]);
      }
    }
  };

  return (
    <div>
      <span>Search by title: </span>
      <input type="text" ref={searchRef} />{" "}
      <input type="radio" ref={movieRef} name="media" id="three" />
      <label>Movie</label>{" "}
      <input type="radio" ref={showRef} name="media" id="four" />
      <label>Show</label>{" "}
      <Button variant="secondary" onClick={handleSearch}>
        Search
      </Button>{" "}
      <br />
      <Table striped bordered hover variant="dark" responsive>
        <thead>
          <tr>
            <th>Title</th>
            <th>Year</th>
            <th>Poster</th>
          </tr>
        </thead>
        <tbody>{movies}</tbody>
      </Table>
    </div>
  );
}

export default SearchBar;
