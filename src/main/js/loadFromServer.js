'use strict';

const React = require('react');
const client = require('./functions/client');
const follow = require('./functions/follow');
const when = require('when');

const root = '/api'

class LoadFromServer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {sensors: [], attributes: [], pageSize: 10, links: {}};
        this.updatePageSize = this.updatePageSize.bind(this);
        this.onCreate = this.onCreate.bind(this);
        this.onDelete = this.onDelete.bind(this);
        this.onNavigate = this.onNavigate.bind(this);
        this.onUpdate = this.onUpdate.bind(this);
    }

    loadFromServer(pageSize) {
        follow(client, root, [
            {rel: 'sensors', params: {size: pageSize}}]
        ).then(sensorCollection => {
            //console.log("loadFromServer:sensorCollection");
            //console.log(sensorCollection);
            return client({
                method: 'GET',
                path: sensorCollection.entity._links.profile.href,
                headers: {'Accept': 'application/schema+json'}
            }).then(schema => {
                this.schema = schema.entity;
                return sensorCollection;
            });
        }).then(sensorCollection => {
            this.setState({links: sensorCollection.entity._links});
            return sensorCollection.entity._embedded.sensors.map(sensor =>
                client({
                    method: 'GET',
                    path: sensor._links.self.href
                })
            );
        }).then(sensorPromises => {
            return when.all(sensorPromises);
        }).done(sensors => {
            //console.log("loadFromServer:sensors")
            //console.log(sensors);
            this.setState({
                sensors: sensors,
                attributes: Object.keys(this.schema.properties),
                pageSize: pageSize,
            });
        });
    }

    onCreate(newSensor) {
        follow(client, root, ['sensors']).then(sensorCollection => {
            return client({
                method: 'POST',
                path: sensorCollection.entity._links.self.href,
                entity: newSensor,
                headers: {'Content-Type': 'application/json'}
            })
        }).then(response => {
            this.loadFromServer(this.state.pageSize);
        });
    }

    onUpdate(sensor, updatedSensor) {
        //console.log("onUpdate: sensor");
        //console.log(sensor);
        //console.log(updatedSensor);
        client({
            method: 'PUT',
            path: sensor._links.self.href,
            entity: updatedSensor,
            headers: {
                'Content-Type': 'application/json',
            }
        }).done(response => {
            this.loadFromServer(this.state.pageSize);
        });
    }

    onDelete(sensor) {
        console.log("onDelete");
        console.log(sensor);
        client({method: 'DELETE', path: sensor.entity._links.self.href}).done(response => {
            this.loadFromServer(this.state.pageSize);
        });
    }

    onNavigate(navUri) {
        client({method: 'GET', path: navUri}).then (sensorCollection => {
            this.links = sensorCollection.entity._links;

            return sensorCollection.entity._embedded.sensors.map(sensor =>
                client({method: 'GET', path: sensor._links.self.href}));
        }).then(sensorPromises => {
            return when.all(sensorPromises);
        }).done(sensors => {
            this.setState({
                sensors: sensors,
                attributes: Object.keys(this.schema.properties),
                pageSize: this.state.pageSize,
                links: this.links
            });
        });
    }

    updatePageSize(pageSize) {
        if (pageSize !== this.state.pageSize) {
            this.loadFromServer(pageSize);
        }
    }

    componentDidMount() {
        this.loadFromServer(this.state.pageSize);
    }
}

export default LoadFromServer(props);