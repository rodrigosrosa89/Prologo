import './styles.css'
import {FaFacebook, FaInstagram, FaLinkedin} from 'react-icons/fa'

function Footer() {
    return (
    <footer className='footer'>
        <ul className='social-list'>
        <li><FaFacebook /></li>
        <li><FaInstagram /></li>
        <li><FaLinkedin /></li>
        </ul>
        <p><span>Costs</span> &copy;2022</p>
    </footer>
    )
}

export default Footer