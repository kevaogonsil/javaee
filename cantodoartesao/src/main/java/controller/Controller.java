package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The produto. */
	JavaBeans produto = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			produtos(request, response);
		} else if (action.equals("/insert")) {
			novoProduto(request, response);
		} else if (action.equals("/select")) {
			listarProduto(request, response);
		} else if (action.equals("/update")) {
			editarProduto(request, response);
		} else if (action.equals("/delete")) {
			removerProduto(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Produtos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// listar produtos
	protected void produtos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados javabeans
		ArrayList<JavaBeans> lista = dao.listarProdutos();
		// encaminhar a lista ao documento cantodoartesao.jsp
		request.setAttribute("produtos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("cantodoartesao.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo produtos
	protected void novoProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// setar as variaveis javabeans
		produto.setIdProduto(request.getParameter("idProduto"));
		produto.setNomeProduto(request.getParameter("nomeProduto"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setPreco(request.getParameter("preco"));
		produto.setQuantidadeEstoque(request.getParameter("quantidadeEstoque"));
		// invocar o método inserirProduto passando o objeto produto
		dao.inserirProduto(produto);
		// redirecionar para o documento .jsp
		response.sendRedirect("main");
	}

	/**
	 * Listar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar produto
	protected void listarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id do produto que será editado
		String idProduto = request.getParameter("idProduto");

		// setar as variaveis Javabeans
		produto.setIdProduto(idProduto);
		// executar o metodo selecionarProduto(DAO)
		dao.selecionarProduto(produto);

		// Setar os atributos do formulário com o conteúdo javabeans
		request.setAttribute("idProduto", produto.getIdProduto());
		request.setAttribute("nomeProduto", produto.getNomeProduto());
		request.setAttribute("descricao", produto.getDescricao());
		request.setAttribute("preco", produto.getPreco());
		request.setAttribute("quantidadeEstoque", produto.getQuantidadeEstoque());
		// encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis JavaBeans
		produto.setIdProduto(request.getParameter("idProduto"));
		produto.setNomeProduto(request.getParameter("nomeProduto"));
		produto.setDescricao(request.getParameter("descricao"));
		produto.setPreco(request.getParameter("preco"));
		produto.setQuantidadeEstoque(request.getParameter("quantidadeEstoque"));
		// executar o metodo alterar produto
		dao.alterarProduto(produto);
		// redirecionar para o documento cantodoartesao.jsp(atualizando as alterações)
		response.sendRedirect("main");
	}

	/**
	 * Remover produto.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// remover um produto
	protected void removerProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do produto a ser excluido(validador.js)
		String idProduto = request.getParameter("idProduto");
		// setar as variaveis idproduto no Javabeans
		produto.setIdProduto(idProduto);
		// executar o metodo deletarProduto(DAO) passando o objeto produto
		dao.deletarProduto(produto);
		// redirecionar para o documento cantodoartesao.jsp(atualizando as alterações)
		response.sendRedirect("main");
	}
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//gerar relatório em pdf
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			//tipo de conteudo
			response.setContentType("apllication/pdf");
			//nome do documento
			response.addHeader("Content-Disposition", "inline;filename="+"produtos.pdf");
			//criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			//abrir o documento->conteudo
			documento.open();
			documento.add(new Paragraph("Lista de Produtos"));
			documento.add(new Paragraph(" "));
			//criar uma tabela
			PdfPTable tabela= new PdfPTable(4);		
			//cabeçalho
			PdfPCell col1 =new PdfPCell(new Paragraph("Nome  do Produto"));
			PdfPCell col2 =new PdfPCell(new Paragraph("Descricao"));
			PdfPCell col3 =new PdfPCell(new Paragraph("Preco"));
			PdfPCell col4 =new PdfPCell(new Paragraph("QuantidadeEstoque"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			//popular a tabela com os produtos
			ArrayList<JavaBeans>lista=dao.listarProdutos();
			for (int i=0;i < lista.size();i++) {
				tabela.addCell(lista.get(i).getNomeProduto());
				tabela.addCell(lista.get(i).getDescricao());
				tabela.addCell(lista.get(i).getPreco());
				tabela.addCell(lista.get(i).getQuantidadeEstoque());
			}
			
			documento.add(tabela);
			documento.close();
			
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}
