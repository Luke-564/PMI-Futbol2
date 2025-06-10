
package pmi.futbol;

import Controlador.ControladorArbitros;
import Controlador.ControladorArchivo;
import java.util.ArrayList; 
import Model.Jugadora;
import Model.Arbitro;
import java.util.HashMap;
import Controlador.ControladorJugadoras;
import Vista.VentanaPrincipal;
import Model.Fecha;

public class PMIFutbol {
    public static void main(String[] args) {
        ArrayList <Jugadora> listaJu = new ArrayList <>();
        ArrayList <Arbitro> listaAr = new ArrayList <>();
        ControladorArbitros contrlArb = new ControladorArbitros(listaAr);
        ControladorArchivo contArc = new ControladorArchivo();
        contArc.incioMemoriaJugadoras(listaJu);
        contArc.inicioMemoriaArbitros(listaAr);
        Fecha fe = new Fecha(1,2,3);
        Jugadora ju = new Jugadora("Delantera", "Boca", 4, 4, 4, "Nombre", 
                "Apellido", fe, "Argentina", "46439");
        listaJu.add(ju);
        contArc.guardarJuEnArchivo(listaJu);
        HashMap<String, Integer> equipos = new HashMap<>();
        ControladorJugadoras controladorJu = new ControladorJugadoras(equipos, listaJu);
        VentanaPrincipal vista = new VentanaPrincipal();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}