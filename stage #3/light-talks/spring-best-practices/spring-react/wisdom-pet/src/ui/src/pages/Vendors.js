import React, { useLayoutEffect, useState } from 'react';

const Vendors = () => {
  const [vendors, setVendors] = useState([])

  useLayoutEffect(() => {
    const getVendors = async() => {
      const res = await fetch('/api/vendors')
      const vendors = await res.json()
      setVendors(vendors)
    }
    getVendors().catch(e => {
      console.log(e)
    })
  },[])

  return(
    <table>
      <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Contact</th>
        <th>Email Address</th>
        <th>Phone Number</th>
        <th>Address</th>
      </tr>
      </thead>
      <tbody>
      {vendors.map(vendor => {
        const {
          vendorId,
          name,
          contact,
          emailAddress,
          phoneNumber,
          address,
        } = vendor;
        return(
          <tr key={vendor}>
            <td>{vendorId}</td>
            <td>{name}</td>
            <td>{contact}</td>
            <td>{emailAddress}</td>
            <td>{phoneNumber}</td>
            <td>{address}</td>
          </tr>
        )
      })}
      </tbody>
    </table>
  )
}
export default Vendors;