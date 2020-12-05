import React, { Component } from 'react';
import NavBarItem from './NavBarItem'
import './navbar.css';



class NavBar extends Component {


    render() {
        return (<div className="NavBar">
                    <NavBarItem imgSrc="icons/home.svg" linkPath="/"/>
                    <NavBarItem imgSrc="icons/darts.svg" linkPath="/challenge"/>
                    <NavBarItem imgSrc="icons/data-transfer.svg" linkPath="/msg"/>
                    <NavBarItem imgSrc="icons/microprocessor.svg" linkPath="events"/>
                    <NavBarItem imgSrc="icons/users.svg" linkPath="/friends"/>
                    <NavBarItem imgSrc="icons/compass.svg" linkPath="localEvents"/>
        </div>);
    }

}

export default NavBar;