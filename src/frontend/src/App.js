import './App.css';
import React, { Component } from 'react';
import { Route } from 'react-router';
import NavBar from './components/navbar/NavBar';
import ChallengePage from './pages/ChallengePage';
import HomePage from './pages/HomePage';
import EventsPage from './pages/EventsPage';
import MsgPage from './pages/MsgPage';
import LandingPage from "./pages/LandingPage";
import ProfilePage from "./pages/ProfilePage";

class App extends Component {

  render() { 
    return (
      <div>
        <Route path="/app" component={NavBar}></Route>
        {/* <Route exact path="/" component={LandingPage}></Route> */}
        <Route exact path="/" component={ProfilePage}></Route>
        <Route exact path="/app/" component={HomePage}></Route>
        <Route exact path="/app/challenge" component={ChallengePage}></Route>
        <Route exact path="/app/events" component={EventsPage}></Route>
        <Route exact path="/app/msg" component={MsgPage}></Route>
      </div>
    );
  }
}

export default App;
