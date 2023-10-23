    import axios from 'axios';
import React, { useState, useEffect } from 'react';
    import { useParams } from 'react-router-dom';
const AddProduct = () => {
    
      const { id } = useParams();
      const [product, setProduct] = useState({ title: '', price: '', quantity: '' });
    
  useEffect(() => {
    axios.get(`http://localhost:8080/products/${id}`)
      .then((response) => {
        setProduct(response.data);
      })
      .catch((error) => {
        console.error('Error fetching product:', error);
      });  }, [id]);
    
      const handleSubmit = () => {
        if (id) {
          axios.put(`http://localhost:8080/products/${id}`, product)
            .then((response) => {
            })
            .catch((error) => {
              console.error('Error updating product:', error);
            });
        } else {
          axios.post(`http://localhost:8080/products`, product)
            .then((response) => {
            })
            .catch((error) => {
              console.error('Error creating product:', error);
            }); 
        }
      };
    
      return (
        <div>
          <h2>{id ? 'Edit Product' : 'Add Product'}</h2>
          <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Title" />
            <input type="number" placeholder="Price" />
            <input type="number" placeholder="Quantity" />
            <button type="submit">Save</button>
          </form>
        </div>
      );
    }
    
    export default AddProduct;