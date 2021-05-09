import { SalePage } from "dtos/sale";
import { useEffect, useState } from "react";
import api from "services/api";
import { formatLocalDate } from "utils/date";

function DataTable() {
  const [page, setPage] = useState<SalePage>();

  useEffect(() => {
    api.get('/sales/all')
      .then(response => response.data)
      .then((page: SalePage) => setPage(page));
  }, []);

  if (!page) {
    return <p>Carregando...</p>;
  }

  return (
    <div className="table-responsive">
      <table className="table table-striped table-sm">
        <thead>
          <tr>
            <th>Data</th>
            <th>Vendedor</th>
            <th>Clientes visitados</th>
            <th>Negócios fechados</th>
            <th>Valor</th>
          </tr>
        </thead>

        <tbody>
          {
            page.content?.map(sale => (
              <tr key={sale.id}>
                <td>{formatLocalDate(sale.date, 'dd/MM/yyyy')}</td>
                <td>{sale.seller.name}</td>
                <td>{sale.visited}</td>
                <td>{sale.deals}</td>
                <td>{sale.amount.toFixed(2)}</td>
              </tr>
            ))
          }
        </tbody>
      </table>
    </div>
  );
}

export default DataTable;