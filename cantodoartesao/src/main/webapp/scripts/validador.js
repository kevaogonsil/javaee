/**
 * validação de formulário
 * @author Kevin Vilas Boas
 */

function validar() {

	let nomeProduto = frmProduto.nomeProduto.value
	let descricao = frmProduto.descricao.value
	let preco = frmProduto.preco.value
	let quantidadeEstoque = frmProduto.quantidadeEstoque.value
	if (nomeProduto === "") {
		alert('Preencha o campo nome do produto!')
		frmProduto.nomeProduto.focus()
		return false
	} else if (descricao === "") {
		alert('Preencha o campo nome do descricao!')
		frmProduto.descricao.focus()
		return false
	} else if (preco === "") {
		alert('Preencha o campo nome do preco!')
		frmProduto.preco.focus()
		return false
	} else if (quantidadeEstoque === "") {
		alert('Preencha o campo nome do quantidade Estoque!')
		frmProduto.quantidadeEstoque.focus()
		return false
	} else {
		document.forms["frmProduto"].submit()
	}
}    
