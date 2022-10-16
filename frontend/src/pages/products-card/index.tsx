import NotificationButton from '../../components/notification-button'
import './styles.css'
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useEffect, useState } from 'react';
import axios from 'axios';
import { BASE_URL } from '../../utils/request';
import { Product } from '../../models/product';


function ProductsCard() {


    const [products, setProducts] = useState<Product[]>([])

    useEffect(() => {
        axios.get(`${BASE_URL}/products`)
        .then(response => {
            setProducts(response.data.content);
        })
    }, []);

    
    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Produtos</h2>
            <div>
                <div className="dsmeta-form-control-container">
                    <input type="text"
                        className="dsmeta-form-control"
                    />
                </div>
            </div>

            <div>
                <table className="dsmeta-sales-table">
                    <thead>
                        <tr>
                            <th className="show992">ID</th>
                            <th className="show576">Nome</th>
                            <th className="show576">Quantidade</th>
                            <th className="show576">Preço</th>
                            <th className="show576">Categoria</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            products.map(product => {
                                return (
                        <tr key={product.id}>
                            <td className="show992">{product.id}</td>
                            <td className="show576">{product.name}</td>
                            <td>{product.quantity}</td>
                            <td className="show992">{product.price.toFixed(2)}</td>
                            <td>{product.price.toFixed(2)}</td>
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
