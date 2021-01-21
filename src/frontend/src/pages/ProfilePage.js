import { Component } from 'react';

class ProfilePage extends Component {

    state = {}

    authViaSpotify() {
        console.log("Connecting to Spotify");
        const meEndpoint = "http://localhost:8080/app/user/fakeMe";
        fetch(meEndpoint, {
            method: "GET",
            mode: 'no-cors'
        })
        .then(res => console.log(`Backend responded with ${res.status} code.`))
        .then(res => {
            this.setState({spotifyProfile: res})
            console.log(res)
        })
        .catch(error => console.log(error));

    }
    
    render() {
        const profile = this.state.spotifyProfile;
        return (
            <div>
                <div className="main-wrapper">
                    <div className="buttons">
                        <h1>Authorize and start using this app</h1>
                        <button className="btn spotify-btn" onClick={this.authViaSpotify}>Use Spotify</button>
                        <div className="black-background spotify-font__paragraph">
                            <h1>{profile}</h1>
                        </div>
                    </div>
                </div>
            </div>


        )
    }
}




export default ProfilePage;