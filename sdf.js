var rates = {
    "EUR" : 0.934,
    "GBP" : 0.791,
    "INR" : 64.659,
    "AUD" : 1.326
};
var value = 0;
var rate = 0;


$(function(){
	$("#dollar").keyup(function(){
		value = Number($("input[name='dollar']").val);

		rate = rates[currency];
		$("#amount").html(rate * value);
	});

	$("#currency").change(function(){
		var currency = $("select[id='currency']").val;

		rate = rates[currency];
		$("#amount").html(rate * value);
	});

});
