import { Component } from 'react'


class Header extends Component {

    state = {}

    componentDidMount() {
        fetch("http://localhost:8080/username1", {
            method: "GET",
            mode: "no-cors",
            credentials: "include"
        })
        // .then(res => res.json())
        .then(res => console.log(res))
        .catch(err => console.log(err));
    }

    render() {
        let userName = "mate";
        if(this.state.userName == null) userName = "mate";
        else userName = this.state.userName;
        return <h1>Hello {userName}!</h1>
    }
}


export default Header;