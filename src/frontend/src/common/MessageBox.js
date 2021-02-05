import React, { Component } from 'react';
import './MessageBox.css';

class MessageEntry extends Component {
    render() {
        return (
            <p className="MessageEntry">{this.props.msgText}</p>
        )
    }
}


class MessageBox extends Component {
    state = {
        messages: [
            "Siema wpadasz dzisiaj czy co",
            "Co tm byczq",
            "Eeeeeelo kope lat"
        ]
    }

    render() {
        return (
            <div className="MessageBoxWrapper">
                <h1>Messages</h1>
                <MessageEntry
                    msgText={this.state.messages[0]}
                ></MessageEntry>
                <MessageEntry
                    msgText={this.state.messages[1]}
                ></MessageEntry>
                <MessageEntry
                    msgText={this.state.messages[2]}
                ></MessageEntry>
            </div>
        )
    }
}

export default MessageBox;
