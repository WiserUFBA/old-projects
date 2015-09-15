var on = false;

$(document).ready( function () {
	$("#sliderTemp").hide();
	$("#displayText").hide();
});


function changeState() {
	if (on == false){
		on = true;
		$("#sliderTemp").show();
		$("#displayText").show();

	}
	else {
		on = false;
		$("#sliderTemp").hide();
		$("#displayText").hide();
	}
}

function changeTemp( value ) {
	$("#displayText").text(value + "°C");
}
