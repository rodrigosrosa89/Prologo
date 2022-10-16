import axios from 'axios';
import { useEffect, useState } from 'react';
import "react-datepicker/dist/react-datepicker.css";
import { Category } from '../../models/category';
import { BASE_URL } from '../../utils/request';
import './styles.css';


function CategoriesCard() {

    const [categories, setCategories] = useState<Category[]>([])

    useEffect(() => {
        axios.get(`${BASE_URL}/categories`)
        .then(response => {
            setCategories(response.data.content);
        })
    }, []);

    
    return (
        <div className="dsmeta-card">
            <h2 className="dsmeta-sales-title">Categorias</h2>
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
                        </tr>
                    </thead>
                    <tbody>
                        {
                            categories.map(category => {
                                return (
                        <tr key={category.id}>
                            <td className="show992">{category.id}</td>
                            <td className="show992">{category.name}</td>
                        </tr>
                                )
                            })
                        }
                        
                        
                    </tbody>

                </table>
            </div>

        </div>)
}

export default CategoriesCard
