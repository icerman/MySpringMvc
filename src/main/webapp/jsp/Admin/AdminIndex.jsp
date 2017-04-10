<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page ="../common/AHead.jsp" flush="true"/><!-- 动态导入页面 -->
    <title>管理页面</title>
    
</head>
<body>

<jsp:include page ="../common/ATop.jsp" flush="true"/><!-- 动态导入页面 -->

<div class="container" style="margin-top: 150px">

    <div id="chart" class="chart" style="width:100%;height:450px;"></div>

</div>

<script>
    var myChart = echarts.init(document.getElementById('chart'));

    var option = {
        title: {
            text: '课程选课统计表'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data: ['已选人数', '可选人数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value'
        },
        yAxis: {
            type: 'category',
            data:${listX}
        },
        series: [
            {
                name: '已选人数',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: ${listSelected}
            },
            {
                name: '可选人数',
                type: 'bar',
                stack: '总量',
                label: {
                    normal: {
                        show: true,
                        position: 'insideRight'
                    }
                },
                data: ${listLeft}
            }
        ]
    };

    myChart.setOption(option);
    window.onresize = myChart.resize;
    window.onload = myChart.resize;

</script>

</body>
</html>
