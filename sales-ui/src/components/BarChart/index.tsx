import { ApexOptions } from 'apexcharts';
import { SaleSuccessBySeller } from 'dtos/sale';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import api from 'services/api';
import { round } from 'utils/number';

type SeriesData = {
  name: string;
  data: number[];
}

type LabelData = {
  categories: string[];
}

type ChartData = {
  labels: LabelData,
  series: SeriesData[];
}

const getChartDataFromSaleSuccess = (saleTotalBySellerList: SaleSuccessBySeller[]): ChartData => {
  return {
    labels: {
      categories: saleTotalBySellerList.map(({ sellerName }) => sellerName)
    },
    series: [
      {
        name: '% Sucesso',
        data: saleTotalBySellerList.map(({ deals, visited }) => round(100 * deals / visited, 1))
      }
    ]
  }
}

function BarChart() {
  const [chartData, setChartData] = useState<ChartData>();

  useEffect(() => {
    api.get('/sales/success-by-seller')
      .then(response => response.data)
      .then((saleTotalBySellerList: SaleSuccessBySeller[]) => setChartData(getChartDataFromSaleSuccess(saleTotalBySellerList)));
  }, []);

  if (!chartData) {
    return <p>Carregando...</p>;
  }

  const options: ApexOptions = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }}
      series={chartData.series}
      type="bar"
      height={240}
    />
  );
}

export default BarChart;