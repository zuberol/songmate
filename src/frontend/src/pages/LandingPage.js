import { Component } from 'react';
import "./../static/css/mains.css";

class MsgPage extends Component {

    authViaSpotify() {
        console.log("Connecting to Spotify");

        const authURLParams = {
            client_id: "86594ad446164e8ba2b311639e5d60a6",
            response_type: "code",
            redirect_uri: "http://localhost:3000",
            scope: "user-read-email user-follow-read",
            state: "34fFs29kd09csrfRandomprotectionString",
            show_dialog: true
        }
        const spotifyAuthURL = new URL("https://accounts.spotify.com/authorize");
        Object.entries(authURLParams).forEach(pair => {
            spotifyAuthURL.searchParams.append(pair[0], pair[1]);
        });
        console.log(spotifyAuthURL.toString())
        // url.searchParams.forEach(p => console.log(p));
        // const spotifyAuthURL = `https://accounts.spotify.com/authorize?client_id=5fe01282e44241328a84e7c5cc169165&response_type=code&redirect_uri=https%3A%2F%2Fexample.com%2Fcallback&scope=user-read-private%20user-read-email&state=34fFs29kd09`;

        window.location.replace(spotifyAuthURL);

        // fetch(spotifyAuthURL, {
        //     method: "GET",
        //     mode: 'no-cors'
        // })
        // .then(res => console.log(res.body))
        // .catch(error => console.log(error))
    }

    componentDidMount() {
        const CURRENT_PAGE_URL = new URL(window.location.href);
        console.log(CURRENT_PAGE_URL.toString());
        if(CURRENT_PAGE_URL.searchParams.get("code") == null || CURRENT_PAGE_URL.searchParams.get("state") == null) return;
        const BACKEND_SERVER_URL = "http://localhost:8080/auth/spotifyAuthPrerequisite";
        const spotifyAuthPrerequisite = JSON.stringify({
            CODE: CURRENT_PAGE_URL.searchParams.get("code"),
            STATE: CURRENT_PAGE_URL.searchParams.get("state")
        });
        fetch(BACKEND_SERVER_URL, {
            method: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: spotifyAuthPrerequisite
            
        })
        .then(res => console.log(`Backend responded with ${res.status} code.`))
        .catch(error => console.log(error));
    }
    
    render() {
        return (
            <div>
                <div className="main-wrapper">
                    <div className="buttons">
                        <h1>Authorize and start using this app</h1>
                        <button className="btn spotify-btn" onClick={this.authViaSpotify}>Use Spotify</button>






                        <div className="main-nav">
                            <img src="images/logo.png" className="logo" alt={""}/>
                            <span className="main-nav__title">Songmate</span>
                        </div>

                        <div className="background-div-one spotify-font__heading">
                            <div className="main-wrapper-one">
                                <p>Find people who value your taste</p>
                            </div>
                        </div>
                        <div className="black-background spotify-font__paragraph">
                            <h1>Some heading</h1>
                            <p>Some information about this app.</p>
                        </div>
                        <div className="background-div-two spotify-font__heading">
                            <div className="main-wrapper-two">
                                <p>Find jamming mate</p>
                            </div>
                        </div>
                        <div className="black-background spotify-font__paragraph">
                            <h1>Our algorithm</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                        </div>
                        <div className="background-div-three">
                            <div className="main-wrapper-three">
                                <p className="spotify-font__heading">Get music recommendation from people who know what you like</p>
                            </div>
                        </div>

                        <footer className="main-footer">
                            <span>Icons made by <a href="https://www.flaticon.com/free-icon/sound_865548" title="Good Ware">Good Ware</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com</a></span>
                            <span>Project by JŻ & KK</span>
                        </footer>




                    </div>
                </div>
            </div>


        )
    }
}




export default MsgPage;