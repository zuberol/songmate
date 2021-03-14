import {Component} from "react";

export default class AlbumCover extends Component {
    render() {
        return (
            <article
                className="album-cover"
                style={{backgroundImage: `url(${this.props.imgUrl})`}}>
                <p>{this.props.title}</p>
            </article>
        )
    }
}