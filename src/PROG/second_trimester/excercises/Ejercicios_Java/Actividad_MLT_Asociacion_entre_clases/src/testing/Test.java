package testing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javabean.Banco;
import javabean.Cliente;
import javabean.DireccionCliente;
import javabean.Factura;
import javabean.Pais;
import javabean.Pedido;
import javabean.TarjetaBancaria;

public class Test {

	public static void main(String[] args) {
		
		// PAISES
		Pais pais1 = new Pais(1, "Finlandia");
		Pais pais2 = new Pais(2, "Colombia");
		// BANCOS
		Banco banco1 = new Banco(1, "Santander", pais1);
		Banco banco2 = new Banco(2, "Fundación la Caixa", pais2);
		// TARJETAS
		TarjetaBancaria tarjeta1 = new TarjetaBancaria(5031755734530604L, 2030, 3, 998, "Alberto Utzer", banco1);
		System.out.println(tarjeta1);
		TarjetaBancaria tarjeta2 = new TarjetaBancaria(4002768694395619L, 2028, 5, 321, "Roberto Máximo Fernández", banco2);
		// CLIENTES
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDate createdAt = localDateTime.toLocalDate();
		DireccionCliente dirCliente1 = new DireccionCliente("C/ Happy, 23", "Distrigo 2", "Maní", pais2);
		Cliente cliente1 = new Cliente("1001", tarjeta2.getTitularTarjeta(), "uftz@gmail.com", createdAt, dirCliente1,
				tarjeta2);
		// PEDIDOS
		Pedido pedido1 = new Pedido(1, LocalDate.now(), "Pendiente", cliente1);
		// FACTURAS
		Factura factura1 = new Factura("230489821", "Servicos energéticos", LocalDate.of(2024, 3, 24), pedido1);
		System.out.println(factura1);
		// INFO FACTURA 1
		System.out.println("******************* INFO FACTURA *******************");
		System.out.println("Descripción factura: " + factura1.getDescripcion());
		System.out.println("Fecha factura: " + factura1.getFechaFactura() + " " + factura1.getPedido().getEstado());
		System.out.println("Nombre cliente pedido: " + factura1.getPedido().getCliente().getNombre());
		System.out.println("Dirección cliente pedido: " + factura1.getPedido().getCliente().getDireccion().getDireccion());
		System.out.println(
				"Nombre titular tarjeta pedido: " + factura1.getPedido().getCliente().getTarjeta().getTitularTarjeta());
		System.out.println("Nombre banco titular tajeta pedido: "
				+ factura1.getPedido().getCliente().getTarjeta().getBanco().getNombre());
		System.out.println("País del banco del titular tarjeta pedido: "
				+ factura1.getPedido().getCliente().getTarjeta().getBanco().getPaisOpera().getNombre());
		System.out.println("País de la dirección del cliente pedido: "
				+ factura1.getPedido().getCliente().getDireccion().getPais().getNombre());
	}

}
