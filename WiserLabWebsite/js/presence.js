/*ToDo
	Editar URL do Get na linha 9
	Mudar o tempo entre requisições na linha 20
*/

$(document).ready(getPresence);

function getPresence(){
	$.get( "http://192.168.0.122:8181/cxf/room/devices/sensor/presence/1", function( data ) {
		if (data.Presence.status == "on"){
			$("#presenceText").text("Existem pessoas na sala.");
			$("#presenceImage").removeClass("opaque");
		}
		else{
			$("#presenceText").text("Não existem pessoas na sala.");
			$("#presenceImage").addClass("opaque");
		}
	} , "json" );

	setTimeout(getPresence, 5000);
}