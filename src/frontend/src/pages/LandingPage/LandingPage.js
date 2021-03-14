import { Component } from 'react';
import "./landing.css";
import logo from '../../static/images/logo.svg';
import SpotifyLoginBtn from './SpotifyLoginBtn.js';
import Footer from '../../common/Footer.js';

export default class LandingPage extends Component {

    render() {
        return (
            <div>
                <div className="fullscreen-banner">
                    <div className="songmate-logo__opaque">
                        <div className="songmate-logo__circular-background">
                            <img className="songmate-logo__svg" src={logo} alt="icon not found"></img>
                        </div>
                        <h4 className="songmate-logo__title">Songmate</h4>
                    </div>
                </div>
                <div className="black-background">
                    <h3>Discover artists and albums</h3>
                    <p>Aliquam erat volutpat. Vestibulum cursus sollicitudin condimentum. Quisque a dolor urna. Vivamus vitae dolor sodales, euismod tellus vel, tempus lacus. Sed eu vulputate sem. Vivamus luctus velit eu urna semper, nec tempor tortor auctor.</p>
                </div>
                <div className="background-div-two">
                    <h2 className="header-shadow"><span>Find jamming mate</span></h2>
                </div>
                <div className="orange-background">
                    <h3>Show others your passion</h3>
                    <p>Pellentesque a tincidunt leo, at aliquet odio. Nam maximus sit amet nibh vel posuere. Nullam egestas ex vitae ante molestie, ut ullamcorper libero euismod. Suspendisse potenti. Sed quis velit urna. Quisque odio nisl, iaculis sit amet mi sit amet, sodales vestibulum augue. Integer metus ex, finibus eget efficitur sed, pulvinar quis ex.</p>
                </div>
                <div className="black-background">
                    <SpotifyLoginBtn/>
                </div>
                <div className="background-div-one">
                    <span className="flipElementBefore"></span>
                    <h2 className="header-shadow"><span>Find people who value your taste</span></h2>
                </div>
                <div className="orange-background">
                    <h3>Be up to date about musical events</h3>
                    <p>Aliquam erat volutpat. Vestibulum cursus sollicitudin condimentum. Quisque a dolor urna. Vivamus vitae dolor sodales, euismod tellus vel, tempus lacus. Sed eu vulputate sem. Vivamus luctus velit eu urna semper, nec tempor tortor auctor.</p>
                </div>
                <div className="background-div-three">
                    <h2 className="header-shadow"><span>Get music recommendation from people who know what you like</span></h2>
                </div>
                <Footer/>
            </div>
        )
    }
}