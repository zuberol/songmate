import React, { Component } from 'react';
import NavBarItem from './NavBarItem'
import './navbar.css';



class NavBar extends Component {


    render() {
        return (<div className="NavBar">
                    <NavBarItem imgSrc="icons/cloud.svg" linkPath="/"/>
                    <NavBarItem imgSrc="icons/darts.svg" linkPath="/challenge"/>
                    <NavBarItem imgSrc="icons/data-transfer.svg" linkPath="/challenge"/>
                    <NavBarItem imgSrc="icons/microprocessor.svg"/>
                    <NavBarItem imgSrc="icons/rattle.svg"/>
                    <NavBarItem imgSrc="icons/home.svg"/>
                    <NavBarItem imgSrc="icons/users.svg"/>
                    <NavBarItem imgSrc="icons/compass.svg"/>
        </div>);
    }

}

export default NavBar;