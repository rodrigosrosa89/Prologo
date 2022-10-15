import NotificationButton from '../../components/notification-button'
import './styles.css'
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Sale } from '../../models/sale';


function ProductsCard() {

    const min = new Date(new Date().setDate(new Date().getDate() - 365));;
    const max = new Date();

    const [minDate, setMinDate] = useState(min);
    const [maxDate, setMaxDate] = useState(max);

    const [sales, setSales] = useState<Sale[]>([])

    useEffect(() => {

        const dMin = minDate.toISOString().slice(0, 10);
        const dMax = maxDate.toISOString().slice(0, 10);

        axios.get(`${BASE_URL}/sales?minDate=${dMin}&maxDate=${dMax}`)
        .then(response => {
            setSales(response.data.content);
        })
    }, [minDate, maxDate]);

    
    return (
        <div className="prologo-card">
            <h2 className="prologo-sales-title">Produtos</h2>
            <div>
                <div className="prologo-form-control-container">
                    <input type="text"
                        className="prologo-form-control"
                    />
                </div>
            </div>

            <div>
                <table className="prologo-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Data</th>
                            <th>Vendedor</th>
                            <th className="show992">Visitas</th>
                            <th className="show992">Vendas</th>
                            <th>Total</th>
                            <th>Notificar</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            sales.map(sale => {
                                return (
                        <tr key={sale.id}>
                            <td className="show992">{sale.id}</td>
                            <td className="show576">{new Date(sale.date).toLocaleDateString()}</td>
                            <td>{sale.sellerName}</td>
                            <td className="show992">{sale.visited}</td>
                            <td className="show992">{sale.deals}</td>
                            <td>{sale.amount.toFixed(2)}</td>
                            <td>
                                <div className="prologo-red-btn-container">
                                    <NotificationButton saleId={sale.id}/>
                                </div>
                            </td>
                        </tr>
                                )
                            })
                        }
                        
                        
                    </tbody>

                </table>
            </div>

        </div>)
}

export default ProductsCard
