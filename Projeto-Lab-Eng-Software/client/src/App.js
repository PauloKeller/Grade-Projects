import React, { Component } from 'react';
import Slider from "react-slick";
import ApolloClient from 'apollo-boost'
import { ApolloProvider } from 'react-apollo'


// Components
import UserInfoForm from './components/UserInfoForm'
import RatingProductForm from './components/RatingProductForm' 

// Apollo Client Setup
const Client = new ApolloClient({
  uri: 'http://localhost:4000/graphql'
})

class App extends Component {
  render() {
    var settings = {
      dots: true,
      infinite: false,
      speed: 500,
      slidesToShow: 1,
      slidesToScroll: 1,
    };
    return (
      <ApolloProvider client={Client}>
        <div className="main">
          <Slider {...settings}>
            <div>
              <UserInfoForm></UserInfoForm>
            </div>
            <div>
              <RatingProductForm></RatingProductForm>
            </div>
            <div>
              
            </div>
          </Slider>
          
        </div>
      </ApolloProvider>
    );
  }
}

export default App;
