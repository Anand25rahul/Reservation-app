import React from 'react'
import "../Styles/landingpage.css"
import { Link } from 'react-router-dom'

const LandingPage=()=> {
  return (
    <div className="landingpage">
        <Link to="/adminlogin">
        <img src="https://e7.pngegg.com/pngimages/9/763/png-clipart-computer-icons-login-user-system-administrator-admin-desktop-wallpaper-megaphone.png" alt="" />
        <h2>Admin</h2>
        </Link>
        <Link to="/userlogin">
            <img src="https://w7.pngwing.com/pngs/505/761/png-transparent-login-computer-icons-avatar-icon-monochrome-black-silhouette-thumbnail.png" alt="" />
            <h2>User</h2>
        </Link>
    </div>
  )
}

export default LandingPage
