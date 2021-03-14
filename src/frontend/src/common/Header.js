import { Component } from 'react';
import './../static/css/commons.css';
import LoggedDropdown from "./LoggedDropdown.js";


export default class Header extends Component {
    render() {
        return (
            <header>
                <a className="logo" href="/app">
                    <div className="logo__black-wrapper">
                        <div className="logo__circular-background">
                            <div className="logo__img"></div>
                        </div>
                    </div>
                    <h5 className="logo-title">Songmate</h5>
                </a>

                <a className="" href="/app/discover">
                    <h5 className="logo-title">discover</h5>
                </a>

                <LoggedDropdown/>
            </header>
        )
    }
}