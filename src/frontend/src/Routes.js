import React, { Component } from 'react';
import { Route } from 'react-router';
import { withCookies } from 'react-cookie';

import ChallengePage from './pages/ChallengePage';
import HomePage from './pages/HomePage';
import EventsPage from './pages/EventsPage';
import MsgPage from './pages/MsgPage';
import LandingPage from "./pages/LandingPage/LandingPage.js";
import ProfilePage from "./pages/ProfilePage/ProfilePage";
import DiscoverPage from "./pages/DiscoverPage.js";

import Header from './common/Header';
import Footer from './common/Footer';

import './static/css/commons.css';




class App extends Component {

    render() {
        return (
            <div>
                <Route path="/app" component={Header}></Route>
                <main>
                    <Route exact path="/" component={LandingPage}></Route>
                    <Route exact path="/app/users/me" component={ProfilePage}></Route>

                    <Route exact path="/app" component={HomePage}></Route>
                    <Route exact path="/app/discover" component={DiscoverPage}></Route>
                    <Route exact path="/app/challenge" component={ChallengePage}></Route>
                    <Route exact path="/app/events" component={EventsPage}></Route>
                    <Route exact path="/app/msg" component={MsgPage}></Route> 
                </main>
                <Route path="/app" component={Footer}></Route> 
            </div>
        );
    }
}

export default withCookies(App);
