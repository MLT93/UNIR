package zz_proyecto_lombok;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "nombre")
@ToString(exclude = "direccion")
public class Contacto_con_lombok {
	private String nombre;
	private String telefono;
	private String direccion;
}
