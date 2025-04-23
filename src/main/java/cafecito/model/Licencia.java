package cafecito.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Licencia {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;
private String hwid;
private String estado;
private LocalDate fechaVencimiento;
// Getters y setters
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }
public String getNombre() { return nombre; }
public void setNombre(String nombre) { this.nombre = nombre; }
public String getHwid() { return hwid; }
public void setHwid(String hwid) { this.hwid = hwid; }
public String getEstado() { return estado; }
public void setEstado(String estado) { this.estado = estado; }
public LocalDate getFechaVencimiento() { return fechaVencimiento; }
public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

}
