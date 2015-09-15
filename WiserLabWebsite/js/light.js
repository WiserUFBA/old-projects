var on = false;

function toggleLight(){
	var $lImg = $("#lightImage");
	var $lTxt = $("#lightText");

	if (on == false){
		$lImg.attr("src", "img/ligthbulb_on.png");
		$lImg.removeClass("opaque");
		$lTxt.text("As lâmpadas estão acesas.");
		on = true;
	}
	else {
		$lImg.attr("src", "img/ligthbulb_off.png");
		$lImg.addClass("opaque");
		$lTxt.text("As lâmpadas estão apagadas.");
		on = false;
	}
}
