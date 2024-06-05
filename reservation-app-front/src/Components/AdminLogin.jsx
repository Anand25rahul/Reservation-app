import React from 'react'
import "../Styles/adminlogin.css"

function AdminLogin() {
  return (
    <div className='AdminLogin'>
        <form action="">
            <label htmlFor="">Username</label>
            <input type="text" placeholder='Enter the UserName' required />
            <label htmlFor="">Password</label>
            <input type="text" placeholder='Enter the Password' required />
        </form>
    </div>
  )
}

export default AdminLogin