import './App.css';
import { BrowserRouter as Router,Routes, Route, Link } from 'react-router-dom'; 
import AddProduct from './pages/product/AddProduct'; 
import ViewProducts from './pages/product/ViewProducts'; 



function App() {
  return (
    <div>
    <Router> 
    <div className="App"> 
        <ul > 
        <li> 
            <Link to="/">Home</Link> 
        </li> 
        
        <li> 
            <Link to="/AddProduct">AddProduct</Link> 
        </li>
        <li> 
            <Link to="/ViewProducts">Products</Link> 
        </li>
        
        </ul> 
    <Routes> 
            <Route exact path='/' element={<ViewProducts />}></Route> 
            <Route exact path='/AddProduct' element={< AddProduct />}></Route>
            <Route exact path='/ViewProducts' element={< ViewProducts />}></Route>
    </Routes> 
    </div> 
</Router>
</div> 
  );
}

export default App;
