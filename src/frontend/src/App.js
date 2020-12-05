import './App.css';
import React, { Component } from 'react';
import { Route } from 'react-router';
import NavBar from './components/navbar/NavBar';
import ChallengePage from './pages/ChallengePage';
import HomePage from './pages/HomePage'
import EventsPage from './pages/EventsPage'
import MsgPage from './pages/MsgPage'

class App extends Component {

  render() { 

    return (
      <div style={{height: "100%", backgroundColor: "red"}}>
        <NavBar/>
        <Route exact path="/" component={HomePage}></Route>
        <Route exact path="/challenge" component={ChallengePage}></Route>
        <Route exact path="/events" component={EventsPage}></Route>
        <Route exact path="/msg" component={MsgPage}></Route>
      </div>
    );
  }
}

export default App;
