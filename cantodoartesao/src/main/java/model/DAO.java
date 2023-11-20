package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de conexao *. */
	// parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/produtos?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "123456";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Métodos de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD Create *.
	 *
	 * @param produto the produto
	 */
	public void inserirProduto(JavaBeans produto) {
		String create = "insert into produtos(nomeProduto,descricao,preco,quantidadeEstoque) values (?,?,?,?)";
		try {
			// abrir a conexao
			Connection con = conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis Javabeans
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getDescricao());
			pst.setString(3, produto.getPreco());
			pst.setString(4, produto.getQuantidadeEstoque());
			// executar a query
			pst.executeUpdate();
			// encerrar conexao com banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD Read *.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarProdutos() {
		// Criando um objeto para acessar a classe javabeans
		ArrayList<JavaBeans> produtos = new ArrayList<>();
		String read = "select * from produtos order by nomeProduto ";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo só será executado enquanto houver p
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String idProduto = rs.getString(1);
				String nomeProduto = rs.getString(2);
				String descricao = rs.getString(3);
				String preco = rs.getString(4);
				String quantidadeEstoque = rs.getString(5);
				// populando o arraylist
				produtos.add(new JavaBeans(idProduto, nomeProduto, descricao, preco, quantidadeEstoque));
			}
			con.close();
			return produtos;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}

	/**
	 *  CRUD Update *.
	 *
	 * @param produto the produto
	 */
	// selecionar produto
	public void selecionarProduto(JavaBeans produto) {
		String read2 = "select * from produtos where idProduto = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, produto.getIdProduto());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				// Setar as variaveis javabeans
				produto.setIdProduto(rs.getString(1));
				produto.setNomeProduto(rs.getString(2));
				produto.setDescricao(rs.getString(3));
				produto.setPreco(rs.getString(4));
				produto.setQuantidadeEstoque(rs.getString(5));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar produto.
	 *
	 * @param produto the produto
	 */
	// editar o contato
	public void alterarProduto(JavaBeans produto) {
		String create = "update produtos set nomeProduto=?,descricao=?,preco=?,quantidadeEstoque=? where idProduto=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, produto.getNomeProduto());
			pst.setString(2, produto.getDescricao());
			pst.setString(3, produto.getPreco());
			pst.setString(4, produto.getQuantidadeEstoque());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD DELETE *.
	 *
	 * @param produto the produto
	 */
	public void deletarProduto(JavaBeans produto) {
		String delete = "delete from produtos where idProduto=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, produto.getIdProduto());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
