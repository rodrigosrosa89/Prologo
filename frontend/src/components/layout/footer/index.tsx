import './styles.css'
import {FaFacebook, FaInstagram, FaLinkedin} from 'react-icons/fa'

function Footer() {
    return (
    <footer className='social-list'>
        <ul>
        <li><FaFacebook /></li>
        <li><FaInstagram /></li>
        <li><FaLinkedin /></li>
        </ul>
    </footer>
    )
}

export default Footer