<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
	<style>
	table{
	width:70%;
	}
table, th, td {
    border: 1px solid black;
    
}
th, td {
    padding: 5px;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js" type="text/javascript"></script>
  <script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.3.3/underscore-min.js" type="text/javascript"></script>
  <script src="http://cdnjs.cloudflare.com/ajax/libs/backbone.js/0.9.2/backbone-min.js" type="text/javascript"></script>
        <script>

            $(function() {
			       
				   
				 var currencyFrom,currencyTo,name;  
			
                var CurrencyRate = Backbone.Model.extend();

                var ExchangeRateList = Backbone.Collection.extend({
                    model: CurrencyRate,
                    url: 'http://localhost:8080/SpringMVC/rest/exchange/list'
                });   
				
				var ConvertCurrency = Backbone.Model.extend({
                   url : function(){
				   return ("http://localhost:8080/SpringMVC/rest/exchange/convert/" + this.get("currencyFrom")+"/"+this.get("currencyTo")); }
                    
                });   
				
				var SearchCurrencyRate = Backbone.Model.extend({
				
                   url : function(){
				   return ("http://localhost:8080/SpringMVC/rest/exchange/search/" + this.get("name")); }
                    
                });   
				
                
                var ExchangeView = Backbone.View.extend({
                    el: "#profiles",
					
                    template: _.template($('#profileTemplate').html()),
					
                    render: function(eventName) {
					$(this.el).append("<tr> <th>Currency Name</th><th>ValueForUSD</th><th>Inverse</th> 	</tr>");
                        _.each(this.model.models, function(rate){
                            var rateTemplate = this.template(rate.toJSON());
							
                            $(this.el).append(rateTemplate);
							
                        }, this);

                        return this;
                    }
                });
				

                var exchangeRates = new ExchangeRateList();    
                var exchangeView = new ExchangeView({model: exchangeRates});
				
				
				var CurrencyConvView = Backbone.View.extend({
                    el: "#currencyConv",
					
                    template: _.template($('#currency_select_template').html()),
					initialize: function(){
						var countries = [];
						var self = this;
						exchangeRates.fetch({
							success: function(){
								self.render();
							}
						});
					},
									 events: {
					"click .convert": "convert",
					
					
				  },
				  
				   

				  convert: function() {
					console.log("Transition up");
					currencyFrom = $( "#currencyFrom" ).val();
					currencyTo = $( "#currencyTo" ).val();
					console.log(currencyFrom);
					var convCurrency = new ConvertCurrency({currencyFrom:currencyFrom,currencyTo:currencyTo});
					convCurrency.fetch({
							success: function(model,response){
								console.log(response);
								$( "#result" ).html(response);
							},
							error: function(model,response){
								console.log('error');
							}
						});
				  },
					
                    render: function(eventName) {
                            
							 var country_select_template = _.template($("#currency_select_template").html(), {
								countries: exchangeRates.toJSON(),
					});
        
					$(this.el).append(country_select_template);
							
                        

                        return this;
                    }
                });
				
				
				exchangeRates.fetch({
					success: function() {
                    	exchangeView.render();
						//currencyView.render();
                    }
                });
				var currencyView = new CurrencyConvView({model: exchangeRates});
				
				
				$("#searchquery").keyup(function(e){	
                     name = $("#searchquery").val();
					var searchCurrencyRate = new SearchCurrencyRate({name:name});
					console.log(name);
					if (name != ''){
					searchCurrencyRate.fetch({
							success: function(model,response){
								console.log(response);
								
								 $("#profiles").html('');
								  var exchRates = new ExchangeRateList(response);  
								  var exchView = new ExchangeView({model: exchRates});
								exchView.render();
								
							},
							error: function(model,response){
								console.log('error');
							}
						});
					
					console.log('search');
	                }
else
{
$("#profiles").html('');
  exchangeView.render();
}					
				});
            });
        </script>
        <title>Currency Exchange </title>
    </head>
    <body>
	
	<h3>  Currency Exchange Rates</h3>
	</br>
	</br>

	
       <div>
		<input type="text" id="searchquery" placeholder="Search currency by name"/>
			<button class="search">Search</button>
			<br/>
		<table id="profiles" style="width:70%;border:solid"  >
		
		</table>
		</div>
		<br/>
		<br/>
		<div id="currencyConv" style="width:70%;border:solid"  >
		
		</div>


        <script id="profileTemplate" type="text/template">
            
				<TR>
                    <td >
                        <%= currencyName %>
                    </td>
                    <td >
                        <%= valueForUSD %>
                    </td>
                    <td >
                        <%= inverse %>
                    </td>
                </TR>

				
				
        </script>
		
		<script type="text/template" id="currency_select_template">
		<h3>Currency Converter</h3>
<br/>
<br/>

		<label>1</label>
        <select id="currencyFrom">
             <% _.each(countries, function(country) {%>
                <option value="<%= country.currencyName %>"><%= country.currencyName %></option>
            <% }); %>
        </select>
		<label>To</label>
		<select id="currencyTo">
             <% _.each(countries, function(country) {%>
                <option value="<%= country.currencyName %>"><%= country.currencyName %></option>
            <% }); %>
        </select>
		<button type="submit" class="convert">Convert</button>
		<br/>
		<br/>
		<div>Converted Value: <span id="result"></span></div>
    </script>
    </body>
</html>

