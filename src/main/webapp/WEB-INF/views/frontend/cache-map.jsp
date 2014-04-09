<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>


<link href="<c:url value="/resources/css/jqplot.css" />" rel="stylesheet">

<script type="text/javascript" src=" <c:url value="/resources/js/jqplot/jquery.jqplot.min.js"/> "></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqplot/jqplot.dateAxisRenderer.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqplot/jqplot.barRenderer.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqplot/jqplot.categoryAxisRenderer.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqplot/jqplot.canvasTextRenderer.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jqplot/jqplot.canvasAxisTickRenderer.min.js" />"></script>


<script class="code" type="text/javascript">

$(document).ready(function() {
		
	  var cacheMapURL="${pageContext.request.contextPath}/getCacheMap";
	  var pageQuery=0;
	  var dbQuery=0;

	  	$.ajax({
									    type: 'GET',
									    url: cacheMapURL,
									    async: false,
									    
									    contentType: "application/json; charset=utf-8", 
									    
									    success: function(data) {
									    	
									    	console.log("cache map JSON: "
							  						+ JSON.stringify(data));
									    	
									    	var i;
									    	var endTime=0;
									    	var startTime=0;
									    	var interval=60*60*24;//past day
									    	for (i = data.length-1; i >=0; i--)
							  				{
									    		var temp=new Date(data[i].pageRequestTime).getDay()*60*60*24+new Date(data[i].pageRequestTime).getHours()*60*60+
							    				new Date(data[i].pageRequestTime).getMinutes()*60+new Date(data[i].pageRequestTime).getSeconds();
									    		if(i==data.length-1)
									    			endTime=temp;									    		
									    		if(endTime-temp>=interval)
									    		{
									    			startTime=temp;
									    			break;									    			
									    		}
									    		
									    		if(parseInt(data[i].pageQuery)==1)
							  						pageQuery++;
							  					if(parseInt(data[i].dbQuery)==1)
							  						dbQuery++;							  			
							  				}
									    	
							  				var line3=[["db query counter", dbQuery],["page query counter: ",pageQuery]];
									    	
									    	var plot1 = $.jqplot('chart2', [line3], {
									    	    title: 'Cache Map(in the past 24h)',
									    	    series:[{renderer:$.jqplot.BarRenderer}],
									    	    axesDefaults: {
									    	        tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
									    	        tickOptions: {
									    	          angle: 0,
									    	          fontSize: '10pt'
									    	        }
									    	    },
									    	    axes: {
									    	      xaxis: {
									    	        renderer: $.jqplot.CategoryAxisRenderer
									    	      }
									    	    }
									    	  });
									    	
									    	
									    }});
	  	

	  	
		//end************************************************************************
	});

</script>



<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">


		<div class="body">

			<div id="cacheMap"></div>

			<div >
				<h1>Simple Cache Monitoring for MongoDB</h1>
			</div>

			<div id="chart2"></div>


		</div>

	</tiles:putAttribute>
</tiles:insertDefinition>