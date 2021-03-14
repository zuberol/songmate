import { Component } from "react";
import HorseSvg from './../static/icons/horse.svg'
import './../static/css/commons.css'

export default class LoggedDropdown extends Component {
    render() {
        return (
            <a href="/app/users/me">
                <img className="circular-img" src={HorseSvg}></img>
            </a>
        )
    }
}