import { Component } from 'react';
import "../static/css/mains.css";
import logo from '../static/images/logo.svg'

class MsgPage extends Component {

    authViaSpotify() {
        window.location.replace("http://localhost:8080/");
    }

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

    loginSpotify() {
        window.location.replace("http://localhost:8080");
    }

    logout() {
        window.location.replace("http://localhost:8080/logout");
    }


    render() {
        return (
            <div>
                <div className="fullscreen-banner">
                    <div className="logo__opaque">
                        <div className="logo__circular-background">
                            <img className="logo__svg" src={logo} alt="icon not found"></img>
                        </div>
                        <h4 className="logo__title">Songmate</h4>
                    </div>
                </div>
                <div className="orange-background">
                    <h3>Show others your passion</h3>
                    <p>Pellentesque a tincidunt leo, at aliquet odio. Nam maximus sit amet nibh vel posuere. Nullam egestas ex vitae ante molestie, ut ullamcorper libero euismod. Suspendisse potenti. Sed quis velit urna. Quisque odio nisl, iaculis sit amet mi sit amet, sodales vestibulum augue. Integer metus ex, finibus eget efficitur sed, pulvinar quis ex.</p>
                </div>
                <div className="background-div-one">
                    <span className="flipElementBefore"></span>
                    <h2 className="header-shadow"><span>Find people who value your taste</span></h2>
                </div>
                <div className="black-background">
                    <h3>Be up to date about musical events</h3>
                    <p>Aliquam erat volutpat. Vestibulum cursus sollicitudin condimentum. Quisque a dolor urna. Vivamus vitae dolor sodales, euismod tellus vel, tempus lacus. Sed eu vulputate sem. Vivamus luctus velit eu urna semper, nec tempor tortor auctor.</p>
                </div>
                <div className="background-div-two">
                    <h2 className="header-shadow"><span>Find jamming mate</span></h2>
                </div>
                <div className="black-background">
                    <h3>Our algorithm</h3>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
                <div className="background-div-three">
                    <h2 className="header-shadow"><span>Get music recommendation from people who know what you like</span></h2>
                </div>
                <footer className="main-footer">
                    <span>Project by JŻ</span>
                </footer>
            </div>
        )
    }
}

export default MsgPage;