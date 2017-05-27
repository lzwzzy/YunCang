
window.onload = function () {
    $.post('/yuncang/chartSaleInfo',{},function (data) {
        if (data){
            chart(data);
        }
    });

};

function chart(data) {
    var today = new Date();

    var lineChartData = {
        labels: [
            moment(today).subtract(6, 'days').format('MM-DD'),
            moment(today).subtract(5, 'days').format('MM-DD'),
            moment(today).subtract(4, 'days').format('MM-DD'),
            moment(today).subtract(3, 'days').format('MM-DD'),
            moment(today).subtract(2, 'days').format('MM-DD'),
            moment(today).subtract(1, 'days').format('MM-DD'),
            moment(today).format('MM-DD')+'(今天)'
        ],
        datasets: [
            {
                label: "销售额",
                fillColor: "rgba(48, 164, 255, 0.2)",
                strokeColor: "rgba(48, 164, 255, 1)",
                pointColor: "rgba(48, 164, 255, 1)",
                pointStrokeColor: "#fff",
                pointHighlightFill: "#fff",
                pointHighlightStroke: "rgba(48, 164, 255, 1)",
                data: [
                    data['_sixDayPrice'],
                    data['_fiveDayPrice'],
                    data['_fourDayPrice'],
                    data['_threeDayPrice'],
                    data['_twoDayPrice'],
                    data['_oneDayPrice'],
                    data['todayPrice']
                ]
            }
        ]

    };

    var chart1 = document.getElementById("line-chart").getContext("2d");
    window.myLine = new Chart(chart1).Line(lineChartData, {
        responsive: true
    });
}