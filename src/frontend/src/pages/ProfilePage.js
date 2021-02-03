import { Component } from 'react';

class ProfilePage extends Component {

    state = {}

    getProfile() {
        
    }
    
    render() {
        const profile = this.state.spotifyProfile;
        return (
            <div>
                <div className="main-wrapper">
                    <div className="buttons">
                        <h1>Your profile page, check console</h1>
                        <button onClick={this.getProfile}>get authorities</button>
                    </div>
                </div>
            </div>
        )
    }
}


export default ProfilePage;