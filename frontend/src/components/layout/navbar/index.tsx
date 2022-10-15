import './styles.css'
import { Link } from 'react-router-dom'
import logo from '../../../assets/img/logo.svg'
import Container from '../container'


function Navbar() {
    return (
        <nav>
            <Container>
                <Link to="/">
                    <img src={logo} alt="Logo" />
                </Link>
                <Link to="/">Home</Link>
                <Link to="/product">Produtos</Link>
                <Link to="/category">Categorias</Link>
                <Link to="/sales">Vendas</Link>
            </Container>
        </nav>
    )
}

export default Navbar