/**
 * Confirmação de exclusão de um contato
 * @autor kevao
 */
function confirmar(idProduto){
	let resposta =confirm("Confirma a exclusão deste produto?")
	if (resposta === true){
		//alert(idProduto)
		window.location.href="delete?idProduto="+idProduto
	}
}