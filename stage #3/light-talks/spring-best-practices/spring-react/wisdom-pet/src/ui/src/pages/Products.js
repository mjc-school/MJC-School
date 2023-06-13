import React, { useLayoutEffect, useState } from 'react';
import { getCurrency } from '../Utils';

const Products = () => {
  const [products, setProducts] = useState([])
  const [vendors, setVendors] = useState(new Map())

  const add = (key, value) => {
    setVendors(prev => new Map([...prev, [key, value]]))
  }

  useLayoutEffect(() => {
      const getProducts = async() => {
        const res = await fetch('/api/products')
        const products = await res.json()
        setProducts(products)
      }
      const getVendors = async () => {
        const res = await fetch('/api/vendors')
        const vendors = await res.json()
        vendors.map(vendor => {
          const {
            vendorId,
            name,
            contact,
            emailAddress,
            phoneNumber,
            address,
          } = vendor;
          add(vendorId, vendor)
        })
      }
      getProducts().catch(e => {
        console.log("error fetching products: " + e)
      });
      getVendors().catch(e => {
        console.log("error fetching vendors: " + e)
      })
    },[]
  )
  return (
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Vendor</th>
      </tr>
      </thead>
      <tbody>
      {products.map(product => {
        const {
          productId,
          name,
          price,
          vendorId
        } = product;
        return (
          <tr key={product}>
            <td>{productId}</td>
            <td>{name}</td>
            <td>{getCurrency(price)}</td>
            <td>{vendors.get(vendorId).name}</td>
          </tr>
        )
      })}
      </tbody>
    </table>
  )
}

export default Products;
