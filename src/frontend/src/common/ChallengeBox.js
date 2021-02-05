import React, { Component } from 'react';
import './Challenge.css';
import ChallengePlaceholder from './ChallengePlaceholder';
import YouTube from 'react-youtube'


class Challenge extends Component {
    state = {
        entryMessage: ""
    }

    render() {
        return (
            <div>
                <h1>Do you like it?</h1>
                <YouTube
                    videoId={this.props.props.youTubeVideoId}
                    className="Player"                // defaults -> null
                    containerClassName="PlayerWrapper" 
                />
                <div className="challengeButtonWrapper">
                    <button className="challengeButton">🔥</button>
                    <button className="challengeButton">💩</button>
                </div>
            </div>
        )
    }

    sendChallengeRating(vote) {
        fetch("http://localhost:8080/api/getChallenge",{
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            //mode: 'cors', // no-cors, *cors, same-origin
            //cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            //credentials: 'same-origin', // include, *same-origin, omit
            credentials: 'include',
            headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: JSON.stringify(vote)
        })
          .then(res => console.log(res.status))
    }
}



class ChallengeBox extends Component {
    state = {
        isLoaded: false,
        challenge: null
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/getChallenge",{
            method: 'GET', // *GET, POST, PUT, DELETE, etc.
            //mode: 'cors', // no-cors, *cors, same-origin
            //cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
            credentials: 'include', // include, *same-origin, omit
            headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
            }
        })
        .then(res => res.json())
        .then(
        (result) => {
            this.setState({
            isLoaded: true,
            challenge: result
            });
        },
        (error) => {
            this.setState({
            isLoaded: true,
            error
            });
        })
    }


    render() {

        let challenge = null;

        if(this.state.challenge) {
            challenge = <Challenge props={this.state.challenge}/>
        } else {
            challenge = null;
        }

        return (
            <div className="ChallengeBoxWrapper">
                {challenge || <ChallengePlaceholder></ChallengePlaceholder>}
            </div>
        )
    }
}

export default ChallengeBox;
