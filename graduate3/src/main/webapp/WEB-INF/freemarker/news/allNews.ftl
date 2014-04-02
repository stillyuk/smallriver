<h1>热点新闻</h1>
<hr/>
<#list allNews as news>
	<a href="${news.newsDate?string("yyyy-MM-dd")}/${news.id}.htm">${news.title}</a>
	<br/>
</#list>
...
<hr/>