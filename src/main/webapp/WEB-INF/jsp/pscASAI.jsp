<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>供电单位/供电质量</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
		<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
		<script src="${pageContext.request.contextPath}/js/echarts-all.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<!-- login begin -->
		<div class="logo">
			<img src="${pageContext.request.contextPath}/img/ele.png" height="50px" style="margin: 0 20px 0 40px;float: left;">	
				<p style="line-height: 50px;margin: 0px;font-size: 26px;">电网供电服务品质评价系统</p>
		</div>
		<!-- login end -->
		<!-- nav begin -->
		<nav class="navbar-uset navbar-default" role="navigation">
			<div class="container-fluid"> 
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse" >
				<ul class="nav navbar-nav">
					<li class=""><a href="#">首页</a></li>
					<li><a href="${pageContext.request.contextPath}/index.html">供电单位</a></li>
					<!-- ${pageContext.request.contextPath}/line.html -->
					<li><a href="javascript:void(0)">供电线路</a></li>
					<!-- ${pageContext.request.contextPath}/station.html -->
					<li><a href="javascript:void(0)">供电台区</a></li>
				</ul>
			</div>
			</div>
		</nav>
		<ul class="breadcrumb breadcrumb-uset" style="padding: 10px 50px;border-bottom: 1px solid #ADADAD;">
		    <li><a href="#">首页</a></li>
		    <li><a href="${pageContext.request.contextPath}/index.html">供电单位</a></li>
			<li><a href="#">供电能力分析</a></li>
		</ul>
		<!-- nav end-->
		<div class="container">
			<div class="row">
				<div class="col-xs-3" style="background-color: #ecf4f7;">
					<div class="row" style="background-color: #fff;">
						<div class="col-md-9" style="background-color: #006F6B;color: #fff;line-height: 40px;border-radius: 5px;">
							<h4>${asai.date}供电能力评分</h4>
						</div>
						<div class="col-md-3" style="color: #000;line-height: 40px;">
							<h4>${asai.score}</h4>
						</div>		
					</div>
					<div class="row">
						<div class="col-md-12">
							<table class="table table-striped">
								<caption>各项指标详细</caption>
								<tbody>
									<tr>
										
										<td>当月城市供电可靠率</td>
										<td>${asai.asai}%</td>
									</tr>
									<tr>
										
										<td>停电总次数</td>
										<td>${asai.pctimes}次</td>
									</tr>
									<tr>
										<td>城市总用户数</td>
										<td>${headcount}户</td>
									</tr>
									<tr>
										<td>检测总时间</td>
										<td id="totalday">${daycount}天</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- 图标展示 begin -->
				<div class="col-xs-9">	
					<div class="row">
						<div class="col-xs-12" id="h" style="height: 290px;">
							
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12" id="h2" style="height: 290px;">
							
						</div>
					</div>
				</div>
				<!-- 图标展示 end -->
			</div>
		</div>
		
		
	
	</body>
	<script type="text/javascript">
	$.post("EverydayASAI",{month :'${asai.date}'},function(data){
		var myChart3 = echarts.init(document.getElementById('h','macarons'));
		/* var data = $.parseJSON(data) */
		var date = new Array()		//覆盖用户数
		var asai = new Array()	//持续时间
	  	var score = new Array()		//停电次数
		for ( var a in data) {
			date.push(data[a].date.split("/")[2]+"日")
			asai.push(data[a].asai)
			score.push(data[a].score)
		}
		option3 = {
			 title: {
			    text: '每日供电能力评分'
			},
			tooltip: {
				trigger: 'axis',
				axisPointer: {
					type: 'cross',
					crossStyle: {
						color: '#999'
					}
				}
			},
			toolbox: {
				feature: {
				
				}
			},
			grid: {
			    left: '1%',
			    right: '1%',
			    bottom: '3%',
			    containLabel: true
			},
			legend: {
				data:['供电能力评分','供电可靠率']
			},
			xAxis: [
				{
					type: 'category',
					data: date,
					axisPointer: {
						type: 'shadow'
					}
				}
			],
			yAxis: [
				{
					type: 'value',
					name: '供电能力评分',
					axisLabel: {
						formatter: '{value} 分'
					}
				},
				{
					type: 'value',
					name: '供电可靠率',
					min: 95,
					max: 100,
					interval: 1,
					axisLabel: {
						formatter: '{value} %'
					}
				}
			],
			series: [
				{
					name:'供电能力评分',
					type:'bar',
					data:score
				},
				{
					name:'供电可靠率',
					type:'line',
					yAxisIndex: 1,
					data:asai
				}
			]
		};		
		myChart3.setOption(option3);
		window.addEventListener("resize",function(){
			myChart3.resize();
		})
	});
		
			
		$.post("EveryPC",{month :'${asai.date}'},function(data){
		var myChart4 = echarts.init(document.getElementById('h2','macarons'));
		//初始化 value 和 date 数组
		/* var data = $.parseJSON(data) */
        var headcount = new Array()		//覆盖用户数
		var duration = new Array()	//持续时间
	  	var times = new Array()		//停电次数
		for ( var a in data) {
			headcount.push(data[a].userNum)
			duration.push((data[a].endTime-data[a].startTime)/60)
			var pcTimes = eval(a)+1
			times.push(pcTimes+"次")
		}
		option4 = {
			 title: {
			    text: '用户停电详细'
			},
			tooltip: {
				trigger: 'axis',
				axisPointer: {
					type: 'cross',
					crossStyle: {
						color: '#999'
					}
				}
			},
			toolbox: {
				feature: {
				
				}
			},
			grid: {
			    left: '1%',
			    right: '1%',
			    bottom: '3%',
			    containLabel: true
			},
			legend: {
				data:['停电覆盖用户数','停电持续时间']
			},
			xAxis: [
				{
					type: 'category',
					data: times,
					axisPointer: {
						type: 'shadow'
					}
				}
			],
			yAxis: [
				{
					type: 'value',
					name: '停电覆盖用户数',
					axisLabel: {
						formatter: '{value} 户'
					}
				},
				{
					type: 'value',
					name: '停电持续时间',
					min: 0,
					max: 24,
					interval: 3,
					axisLabel: {
						formatter: '{value} h'
					}
				}
			],
			series: [
				{
					name:'停电覆盖用户数',
					type:'bar',
					data:headcount
				},
				{
					name:'停电持续时间',
					type:'line',
					yAxisIndex: 1,
					data:duration
				}
			]
		};		
		myChart4.setOption(option4);
		window.addEventListener("resize",function(){
			myChart4.resize();
		})
		});
    </script>
</html>
