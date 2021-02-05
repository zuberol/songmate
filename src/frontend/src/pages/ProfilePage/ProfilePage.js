import { Component } from 'react';
import './profile.css';
import './../../static/css/commons.css';
import AlbumCover from './AlbumCover.js';

import mockUser from './../../common/User/MockUser.js';
import User from '../../common/User/User';
import Artist from '../../common/User/Artist.js';


export default class ProfilePage extends Component {

    state = {
        user: null
    }

    componentDidMount() {
        fetch("http://localhost:8080/api/artists/usersTopArtists", {
            method: "GET",
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            credentials: 'include'
        })
        .then(res => res.json())
        .then(res => res.items.map(item => new Artist(
                item.name,
                item.images[0].url,
                item.genres
        )))
        .then(artistList => {
            fetch("http://localhost:8080/api/users/me", {
                method: "GET",
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                credentials: 'include'
            })
            .then(res => res.json())
            .then(userRes => new User(
                userRes.displayName,
                userRes.images[0].url,
                artistList,
                mockUser.about  // todo delete that
            ))
            .then(user => {
                this.setState({user: user})
            })
            .catch(err => console.log(err));
        })
        .catch(err => console.log(err));
    }

    getArtistArticles(artistList) {
        return artistList.map((artist, index) => 
                <AlbumCover 
                    imgUrl={artist.pictureURL}
                    title={artist.name} 
                    key={index}   
                />);
    }

    render() {
        if(this.state.user != null) {
            return (
                <div>
                    <main className="page-content">
                        <section className="profile">
                            <img className="profile__picture" src={this.state.user.profilePictureURL} alt="description"></img>
                            <h4>{this.state.user.display_name}</h4>
                            <div className="profile__info">
                                <h5>About</h5>
                                <p>{this.state.user.about}</p>
                            </div>
                        </section>
                        <section className="albums-grid">
                            <h5>Favourite artists</h5>
                            <div className="albums-grid__articles">
                                {this.getArtistArticles(this.state.user.topArtistList)}
                            </div>
                        </section>
                    </main>
                </div>
            )
        } else {
            return <div>no user</div>
        }
    }
}