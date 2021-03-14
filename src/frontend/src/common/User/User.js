export default class User {
    constructor(display_name, profilePictureURL, topArtistList, about) {
        this.display_name = display_name;
        this.profilePictureURL = profilePictureURL;
        this.topArtistList = topArtistList;
        this.about = about;
    }
    get topArtistList(){ return this._topArtistList }
    set topArtistList(value){ this._topArtistList = value }
}