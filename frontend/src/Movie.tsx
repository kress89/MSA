function Movie({ data }: any) {
  const stil = {
    maxWidth: 256,
    maxHeigth: 256,
    height: 128,
    width: 128,
  };
  return (
    <tr>
      <td>{data.naziv}</td>
      <td>{data.dodaci}</td>
      <td>
        <a href={data.opis} target="_blank" rel="noreferrer">
          <img src={data.opis} alt="poster" style={stil} />
        </a>
      </td>
    </tr>
  );
}

export default Movie;
