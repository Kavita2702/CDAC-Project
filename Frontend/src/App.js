import './App.css';
import Home from './Home';


import Footer  from './Footer';
import Product from './Product'
import CheckoutCart from './CheckoutCart';
import Header from './Header';
import {ContextProvider, cartState, reducer } from './ContextProvider'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Routes,
  Link
} from "react-router-dom";

function App() {
  return (
    <ContextProvider reducer={reducer} cartState={cartState}>
    <div>
     
       <Router>
       <Header></Header>
       <Routes>
       <Route exact path="/product/:id" element={<Product />}/>
       <Route exact path="/checkoutcart" element={<CheckoutCart />}/>
       <Route exact path="/" element={<Home />}>
      </Route> 
      </Routes>
      <Footer></Footer>
      </Router>
    </div>
    </ContextProvider>
  );
}

export default App;
