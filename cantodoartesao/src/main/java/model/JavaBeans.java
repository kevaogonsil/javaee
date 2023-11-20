package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {

/** The id produto. */
private  String idProduto;

/** The nome produto. */
private  String nomeProduto;

/** The descricao. */
private  String descricao;

/** The preco. */
private  String  preco;

/** The quantidade estoque. */
private  String  quantidadeEstoque;


/**
 * Instantiates a new java beans.
 */
public JavaBeans() {
	super();
	
}

/**
 * Instantiates a new java beans.
 *
 * @param idProduto the id produto
 * @param nomeProduto the nome produto
 * @param descricao the descricao
 * @param preco the preco
 * @param quantidadeEstoque the quantidade estoque
 */
public JavaBeans(String idProduto, String nomeProduto, String descricao, String preco, String quantidadeEstoque) {
	super();
	this.idProduto = idProduto;
	this.nomeProduto = nomeProduto;
	this.descricao = descricao;
	this.preco = preco;
	this.quantidadeEstoque = quantidadeEstoque;
}

/**
 * Gets the id produto.
 *
 * @return the id produto
 */
public String getIdProduto() {
	return idProduto;
}

/**
 * Sets the id produto.
 *
 * @param idProduto the new id produto
 */
public void setIdProduto(String idProduto) {
	this.idProduto = idProduto;
}

/**
 * Gets the nome produto.
 *
 * @return the nome produto
 */
public String getNomeProduto() {
	return nomeProduto;
}

/**
 * Sets the nome produto.
 *
 * @param nomeProduto the new nome produto
 */
public void setNomeProduto(String nomeProduto) {
	this.nomeProduto = nomeProduto;
}

/**
 * Gets the descricao.
 *
 * @return the descricao
 */
public String getDescricao() {
	return descricao;
}

/**
 * Sets the descricao.
 *
 * @param descricao the new descricao
 */
public void setDescricao(String descricao) {
	this.descricao = descricao;
}

/**
 * Gets the preco.
 *
 * @return the preco
 */
public String getPreco() {
	return preco;
}

/**
 * Sets the preco.
 *
 * @param preco the new preco
 */
public void setPreco(String preco) {
	this.preco = preco;
}

/**
 * Gets the quantidade estoque.
 *
 * @return the quantidade estoque
 */
public String getQuantidadeEstoque() {
	return quantidadeEstoque;
}

/**
 * Sets the quantidade estoque.
 *
 * @param quantidadeEstoque the new quantidade estoque
 */
public void setQuantidadeEstoque(String quantidadeEstoque) {
	this.quantidadeEstoque = quantidadeEstoque;
}

}

