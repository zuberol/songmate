import React, { Component } from 'react';
import NavBarItem from './NavBarItem'
import './navbar.css';

class NavBar extends Component {

    render() {
        return (<div className="NavBar">
                    <NavBarItem imgSrc="static/icons/home.svg" linkPath="/"/>
                    <NavBarItem imgSrc="static/icons/darts.svg" linkPath="/challenge"/>
                    <NavBarItem imgSrc="static/icons/data-transfer.svg" linkPath="/msg"/>
                    <NavBarItem imgSrc="static/icons/microprocessor.svg" linkPath="events"/>
                    <NavBarItem imgSrc="static/icons/users.svg" linkPath="/friends"/>
                    <NavBarItem imgSrc="static/icons/compass.svg" linkPath="localEvents"/>
        </div>);
    }

}

export default NavBar;