import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class NavBarItem extends Component {
    render() {
        return (
            <Link to={this.props.linkPath || "/"}>
                <img className="NavBarItem" src={this.props.imgSrc} alt="icon not found"></img>
            </Link>
        )
    }
}

export default NavBarItem;