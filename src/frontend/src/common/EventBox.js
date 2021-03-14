import React, { Component } from 'react';
import './EventBox.css';


class EventEntry extends Component {
    state = {
        entryMessage: ""
    }
    render() {
        return (
            <div>
                <p className="EventEntry">{this.props.entryMessage}</p>
            </div>
        )
    }
}

class EventBox extends Component {
    state = {
        messages: [
            {
                id: "312312312",    //some unique id w DOM, np. z bazy danych
                msg: "Margaret just posted new global challenge called \"Sing it for me\""
            },
            {
                id: "13235643432",
                msg: "Jack shared new concert memory"
            },
            {
                id: "456787965",
                msg: "Mark commented an article"
            }
        ]
    }

    render() {
        return (
            <div className="EventBoxWrapper">
                <h1>Events</h1>
                {this.state.messages.map(msgObj => {
                    return <EventEntry entryMessage={msgObj.msg} key={msgObj.id}/>
                    //return (<h1>msg</h1>) <-- po to sa nawiasy potrzebne ()
                })}

            </div>
        )
    }
}

export default EventBox;
