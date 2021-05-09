import { SaleTotalBySeller } from 'dtos/sale';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import api from 'services/api';

type ChartData = {
  labels: string[];
  series: number[];
}

const getChartDataFromSaleTotal = (saleTotalBySellerList: SaleTotalBySeller[]): ChartData => {
  return {
    labels: saleTotalBySellerList.map(({ sellerName }) => sellerName),
    series: saleTotalBySellerList.map(({ total }) => total)
  }
}

function DonutChart() {
  const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

  useEffect(() => {
    api.get('/sales/total-by-seller')
      .then(response => response.data)
      .then((saleTotalBySellerList: SaleTotalBySeller[]) => setChartData(getChartDataFromSaleTotal(saleTotalBySellerList)));
  }, []);

  const options = {
    legend: {
      show: true
    }
  }

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height={240}
    />
  );
}

export default DonutChart;