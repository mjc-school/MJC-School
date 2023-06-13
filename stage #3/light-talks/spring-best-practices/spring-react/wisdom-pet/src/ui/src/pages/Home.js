import React from 'react';
import { Link } from 'react-router-dom'

const Home = () => {
  return (
    <>
      <h3>Admin</h3>
      <ul style={{listStyleType: 'none'}}>
        <li><Link to={'/customers'}>Customers</Link></li>
        <li><Link to={'/products'}>Products</Link></li>
        <li><Link to={'/services'}>Services</Link></li>
        <li><Link to={'/vendors'}>Vendors</Link></li>
      </ul>
    </>
  )
};
export default Home;