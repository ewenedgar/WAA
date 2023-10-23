import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

function ViewProducts() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios.get(`http://localhost:8080/products`)
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error('Error fetching product:', error);
      });}, []);
 const handleDelete = (id) => {     
    axios.delete(`http://localhost:8080/products/${id}`)
      .then((response) => {
        const newProducts = products.filter((product) => product.id !== id);
        setProducts(newProducts);
      })
      .catch((error) => {
        console.error('Error deleting product:', error);
      });  };
      
  return (
    <div>
      <h1>Product List</h1>
      <Link to="/products/add">Add Product</Link>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => (
            <tr key={product.id}>
              <td>{product.id}</td>
              <td>{product.title}</td>
              <td>{product.price}</td>
              <td>{product.quantity}</td>
              <td>
                <Link to={`/products/edit/${product.id}`}>Edit</Link>
                <button onClick={() => handleDelete(product.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default ViewProducts;





