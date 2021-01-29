import React, {Component} from "react"
//https://github.com/bmorelli25/react-svg-line-chart/blob/master/1_basic_line_chart/src/LineChart.js

class LineChart extends Component {
    // GET MAX & MIN X
    getMinX() {
        const {data} = this.props;
        return data[0].x;
    }

    getMaxX() {
        const {data} = this.props;
        return data[data.length - 1].x;
    }

    // GET MAX & MIN Y
    getMinY() {
        const {data} = this.props;
        return data.reduce((min, p) => p.y < min ? p.y : min, data[0].y);
    }

    getMaxY() {
        const {data} = this.props;
        return data.reduce((max, p) => p.y > max ? p.y : max, data[0].y);
    }

    // GET SVG COORDINATES
    getSvgX(x) {
        const {svgWidth} = this.props;
        return (x / this.getMaxX() * svgWidth);
    }

    getSvgY(y) {
        const {svgHeight} = this.props;
        return svgHeight - (y / this.getMaxY() * svgHeight);
    }

    // BUILD SVG PATH
    makePath() {
        const {data, color} = this.props;
        let pathD = "M " + this.getSvgX(data[0].x) + " " + this.getSvgY(data[0].y) + " ";

        pathD += data.map((point, i) => {
            return "L " + this.getSvgX(point.x) + " " + this.getSvgY(point.y) + " ";
        });

        return (
            <path className="linechart_path" d={pathD} style={{stroke: color}}/>
        );
    }
}

// DEFAULT PROPS
LineChart.defaultProps = {
    data: [],
    color: '#2196F3',
    svgHeight: 300,
    svgWidth: 700
}

export default LineChart;