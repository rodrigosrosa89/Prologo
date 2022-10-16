import './styles.css'
import { Link } from 'react-router-dom'
import Container from '../container'


function Navbar() {
    return (
        <nav className='navbar'>
                <ul className='list'>
                    <li className='item'><Link to="/">Home</Link></li>
                    <li className='item'><Link to="/product">Produtos</Link></li>
                    <li className='item'><Link to="/category">Categorias</Link></li>
                    <li className='item'><Link to="/sales">Vendas</Link></li>
                </ul>
        </nav>
    )
}

export default Navbar