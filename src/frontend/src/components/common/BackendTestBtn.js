import { Component } from 'react'
import { withCookies, Cookies } from 'react-cookie';
import { instanceOf } from 'prop-types';


class BackendTestBtn extends Component {
    
    componentDidMount() {
        // console.log("cookies: " + document.cookie);
    }

    testBackend() {
        fetch("http://localhost:8080/artists", {
            method: "GET",
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            credentials: 'include'
        })
        .then(res => res.json())
        .then(res => console.log(res))
        .catch(err => console.log(err));
    }

    loginSpotify() {
        window.location.replace("http://localhost:8080");
    }

    logout() {
        window.location.replace("http://localhost:8080/logout");
    }

    render() {

        return <div>
            <button onClick={this.testBackend}>GET /artists</button>
            <button onClick={this.loginSpotify}>window.location.replace("/")</button>
            <button onClick={this.logout}>logout</button>
        </div>
    }
}


export default withCookies(BackendTestBtn);