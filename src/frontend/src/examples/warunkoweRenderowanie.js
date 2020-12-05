import './App.css';
import React, { Component } from 'react';
import { Route } from 'react-router';
import EventBox from './components/EventBox';
import MessageBox from './components/MessageBox';
import ChallengeBox from './components/ChallengeBox';
import NavBar from './components/navbar/NavBar';

class App extends Component {
  state = {
    showApp: false
  }

  toggleHiddenDiv = () => this.setState({showApp: !this.state.showApp})
  

  render() { 

    let hiddenDiv = null;

    if(this.state.showApp) {
        hiddenDiv = (
          <div style={{'backgroundColor': 'red'}}>
            <h1>this should be visible on click</h1>
          </div>
        )
    }
    else {
      hiddenDiv = null
    }

    return (
      <div>
        <Route exact path="/" render={() => {
          return <h1>Content for '/' hello</h1>
        }}/>
        <Route path="/" component={NavBar}></Route>
        <ChallengeBox/>
        <EventBox />
        <MessageBox />
        <button onClick={this.toggleHiddenDiv.bind(this)}>Click to see smth</button>
        {hiddenDiv}
      </div>
    );
  }
}

export default App;
