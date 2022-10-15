import Header from "./components/layout/header"
import Home from "./pages/home"
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom'
import SalesCard from "./pages/categories-card";
import ProductsCard from "./pages/products-card";
import CategoriesCard from "./pages/categories-card";

import Container from './components/layout/container'
import Navbar from "./components/layout/navbar";
import Footer from "./components/layout/footer";

function App() {
  return (
    <>
    <Header />
      <Router>
        <Navbar/>
        <Switch>
          <Container>
          <Route exact path="/">
            <Home />
          </Route>
          <Route exact path="/product">
            <ProductsCard />
          </Route>
          <Route exact path="/category">
            <CategoriesCard />
          </Route>
          <Route exact path="/sales">
            <SalesCard />
          </Route>
          </Container >
        </Switch>
        <Footer/>
      </Router>
      <ToastContainer />
    </>
  )
}

export default App
