<!DOCTYPE html>
<html>
<body>

<h2>JavaScript Functions</h2>

<p>This example calls a function which performs a calculation, and returns the result:</p>

<p id="demo"></p>

<script>
function proximoDiaDaSemana(proximoDiaSemana) {
	const totalDiasSemana = 7; 
    var data = new Date();
    var atualDiaSemana = (data.getDay() + 1);
    var quantidadeDiasProximoDia = 0;
    
    if(atualDiaSemana == proximoDiaSemana){
    	quantidadeDiasProximoDia = totalDiasSemana;
    }else if(atualDiaSemana <= proximoDiaSemana){
    	quantidadeDiasProximoDia = Math.abs(atualDiaSemana - proximoDiaSemana);
    }else{
    	quantidadeDiasProximoDia = (totalDiasSemana - Math.abs(atualDiaSemana - proximoDiaSemana));
    }
    
    var proximoData = new Date(data.setDate(data.getDate() + quantidadeDiasProximoDia))
    
    return formatDate(proximoData);
}

function formataData(data) {
 	var dia = data.getDate();
    var mes = data.getMonth() + 1;
    var ano = data.getFullYear();
    if (dia < 10) {
      dia = '0' + dia;
    }
    if (mes < 10) {
      mes = '0' + mes;
    }
    return ano + '-' + mes + '-' + dia ;
}

function feriado() {
 	var data = new Date();
    data.setMonth(11, 25);
    return formataData(data);
}
document.getElementById("demo").innerHTML = feriado();
</script>

</body>
</html>