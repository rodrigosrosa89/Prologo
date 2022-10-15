import logo from '../../../assets/img/logo.svg'
import './styles.css'

function Header() {
    return (
    <header>
        <div className="prologo-logo-container">
            <img src={logo} alt="Logo" className='logo-header' />
            <h1>Prólogo - Gerenciamento de produtos</h1>
            <p>
                Desenvolvido por 
                <a href="https://www.instagram.com/prologo"> Eduardo e Rodrigo</a>
            </p>
        </div>
    </header>
    )
}

export default Header