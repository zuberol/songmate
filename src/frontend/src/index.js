import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import EventBox from './components/EventBox';
import MessageBox from './components/MessageBox'
import reportWebVitals from './reportWebVitals';
import App from './App.js'
import ChallengeBox from './components/ChallengeBox'
import NavBar from './components/navbar/NavBar'
import { BrowserRouter, Route } from 'react-router-dom';

ReactDOM.render(
  <React.StrictMode>
    <BrowserRouter>
      <div className="BoxesWrapper">
        <Route exact path="/" component={NavBar}></Route>
        <ChallengeBox/>
        <EventBox />
        <MessageBox />
        <App/>
      </div>
    </BrowserRouter>

  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
