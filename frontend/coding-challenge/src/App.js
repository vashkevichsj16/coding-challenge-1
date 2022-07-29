import logo from './logo.svg';
import './App.css';
import {useState, useEffect } from "react";
import Product from "./component/Product";

function App() {

  const [data, setData] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8081/api/product/all`,
        { method: 'GET',
            headers: {
                "Accept": "application/json"
            }})
        .then((actualData) => {
          // setData(actualData.json());
            actualData.json().then(json => {
                console.log(json);
                setData(json);
            });
          setError(null);
        })
        .catch((err) => {
          setError(err.message);
          setData(null);
        })
  },  []);

  return (
    <div className="App">
        <div className="productsWrapper">
            {data.map(
                it => <Product productData={it}></Product>
            )}
        </div>
    </div>
  );
}

export default App;
