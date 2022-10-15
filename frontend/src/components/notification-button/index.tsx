import icon from '../../assets/img/notification-icon.svg';
import axios from 'axios';
import './styles.css'
import { BASE_URL } from '../../utils/request';

type Props = {
    saleId: number;
}

function handleClick(saleId :number) {
    axios(`${BASE_URL}/sales/notification/${saleId}`)
    .then(response => {
        console.log(response + "SMS enviado com sucesso no processo de notificação")
    })
}

function NotificationButton( {saleId} : Props) {
    return (
        <div className="prologo-red-btn" onClick={() => handleClick(saleId)}>
            <img src={icon} alt="Notificar" />
        </div>
    )

}

export default NotificationButton


