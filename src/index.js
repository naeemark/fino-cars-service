import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import 'bootstrap/dist/css/bootstrap.css';
import {
  Row, Col, Card, CardBody, CardTitle, CardText, CardImg, CardSubtitle, Navbar, NavbarBrand
} from 'reactstrap';
import './index.css'


class ContentFeed extends Component {
  constructor() {
    super();

    this.state = {      
      'items': []
    }    
  }
  componentDidMount() {
    this.getItems();
  }
  
  getItems() {
    fetch(getPageUri())
    .then(results => results.json())
    .then(results => this.setState({'items': results}));
  }
  render() {
    return (
      <div>

      
         <Navbar
    className="my-2"
    color="dark"
    dark
  >
    <NavbarBrand href="/">
      <img
        alt="logo"
        src="/icon.png"
        style={{
          height: 40,
          width: 40,
          marginRight: 20
        }}
      />
      Fino Cars Service
    </NavbarBrand>
  </Navbar>
  <Card    body    className="text-end my-2 Title"          >
    <CardTitle tag="h5">
      Welcome { (process.env.REACT_APP_HOST_NAME) ? ` to [${process.env.REACT_APP_HOST_NAME}]`: "" }      
    </CardTitle>
    <CardText> BackendUri: {`${process.env.REACT_APP_BACKEND_URI}`} </CardText>
  </Card>  

      <ul>        
        {this.state.items.map(function(item, index) {
          return <ContentItem item={item} key={index} />
        })}
      </ul>
        </div>
    );
  }  
}

const getPageUri = () => {  
  var min = 1;
  var max = 30;  
  const randomNumber = parseInt(min + (Math.random() * (max-min)), 10);
  return `${process.env.REACT_APP_BACKEND_URI}/cars/page?number=${randomNumber}&size=10`;
}

const ContentItem = ({ item }) => (
  <Row className="ContentItem">
    <Col xs="3" />
    <Col xs="12" sm="6">
      <Card color="secondary" outline>
        <CardBody>
          <CardTitle tag="h5" className="CardTitle">     
            {item.make} - {item.modelYear}
          </CardTitle>
          <CardSubtitle className="mb-2 text-muted" tag="h6">
            {item.year} - {item.engineType}
          </CardSubtitle>
          <CardText>
            {item.classification} - {item.transmission} {item.type}
          </CardText>
        </CardBody>
        <CardImg top width="50%" src={item.imageUri}></CardImg>
      </Card>
    </Col>
  </Row>
)

ReactDOM.render(  
  <ContentFeed />,
  document.getElementById('root')
);
