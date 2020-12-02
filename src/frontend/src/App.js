import './App.css';
import React, { Component } from 'react';
import { Route } from 'react-router';

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
        <button onClick={this.toggleHiddenDiv.bind(this)}>Click to see smth</button>
        {hiddenDiv}
      </div>
    );
  }
}

export default App;
