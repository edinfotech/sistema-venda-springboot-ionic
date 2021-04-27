package com.edivanio.springboot.Ionic;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edivanio.springboot.Ionic.domain.Categoria;
import com.edivanio.springboot.Ionic.domain.Cidade;
import com.edivanio.springboot.Ionic.domain.Cliente;
import com.edivanio.springboot.Ionic.domain.Endereco;
import com.edivanio.springboot.Ionic.domain.Estado;
import com.edivanio.springboot.Ionic.domain.ItemPedido;
import com.edivanio.springboot.Ionic.domain.Pagamento;
import com.edivanio.springboot.Ionic.domain.PagamentoComBoleto;
import com.edivanio.springboot.Ionic.domain.PagamentoComCartao;
import com.edivanio.springboot.Ionic.domain.Pedido;
import com.edivanio.springboot.Ionic.domain.Produto;
import com.edivanio.springboot.Ionic.enums.StatusPagamento;
import com.edivanio.springboot.Ionic.enums.TipoCliente;
import com.edivanio.springboot.Ionic.repository.CategoriaRepository;
import com.edivanio.springboot.Ionic.repository.CidadeRepository;
import com.edivanio.springboot.Ionic.repository.ClienteRepository;
import com.edivanio.springboot.Ionic.repository.EnderecoRepository;
import com.edivanio.springboot.Ionic.repository.EstadoRepository;
import com.edivanio.springboot.Ionic.repository.ItemPedidoRepository;
import com.edivanio.springboot.Ionic.repository.PagamentoRepository;
import com.edivanio.springboot.Ionic.repository.PedidoRepository;
import com.edivanio.springboot.Ionic.repository.ProdutoRepository;

@SpringBootApplication
public class SistemaSpringbootComIonicApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaSpringbootComIonicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 =  new Categoria(null, "Informática");
		Categoria cat2 =  new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 50.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().add(p2);
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "Sao Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia",est1);
		Cidade c2 = new Cidade(null, "Sao Paulo",est2);
		Cidade c3 = new Cidade(null, "Peruibe",est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Cliente cli1 = new Cliente(null, "Miguel", "miguel@gmail.com", "222222222", TipoCliente.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("(13)3453-2255","(13)3455-7146"));
		
		Endereco end1 = new Endereco(null, "rua Reinaldo", "315", "casa1", "Romar", "11750-000", cli1, c3);
		Endereco end2 = new Endereco(null, "rua Vergeiro", "1211", "apto2", "Centro", "11750-000", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"),cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"),cli1, end2);
		
		
		Pagamento pgto1 = new PagamentoComCartao(null, StatusPagamento.PAGAMENTO_EFETUADO,3, ped1);
		Pagamento pgto2 = new PagamentoComBoleto(null,StatusPagamento.PENDENTE,sdf.parse("10/10/2017 00:00"),null ,ped2);
		
		ped1.setPagamento(pgto1);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pgto1,pgto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, null, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, null, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip2));
		p3.getItens().addAll(Arrays.asList(ip3));
		
		itemPedidoRepository.saveAll((Arrays.asList(ip1,ip2,ip3)));
	}

}
