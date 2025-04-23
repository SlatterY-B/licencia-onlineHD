package cafecito.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cafecito.repository.LicenciaRepository;

@RestController
@RequestMapping("/api/licencia")
public class LicenciaController {

   private final LicenciaRepository licenciaRepository;
   public LicenciaController(LicenciaRepository licenciaRepository) {
       this.licenciaRepository = licenciaRepository;
   }
   @GetMapping
   public Map<String, Object> validarLicencia(@RequestParam String hwid) {
       Map<String, Object> respuesta = new HashMap<>();
       licenciaRepository.findByHwid(hwid).ifPresentOrElse(licencia -> {
           if (licencia.getEstado().equalsIgnoreCase("activo") &&
               licencia.getFechaVencimiento().isAfter(LocalDate.now())) {
               respuesta.put("estado", "activo");
               respuesta.put("vence", licencia.getFechaVencimiento().toString());
           } else {
               respuesta.put("estado", "bloqueado");
           }
       }, () -> {
           respuesta.put("estado", "no_registrado");
       });
       return respuesta;
   }

}
